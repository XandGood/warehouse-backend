package com.warehouseBack.interceptor;

import com.warehouseBack.annotation.RequireRole;
import com.warehouseBack.domain.User;
import com.warehouseBack.service.IUserService;
import com.warehouseBack.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private final IUserService userService;

    // 通过构造函数注入
    public LoginInterceptor(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取请求头中的Token
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            response.setStatus(401);
            response.getWriter().write("未登录或Token格式错误");
            return false;
        }

        // 2. 截取Token（去除"Bearer "前缀）
        token = token.substring(7);

        // 3. 验证Token
        if (!JwtUtils.validateToken(token)) {
            response.setStatus(401);
            response.getWriter().write("Token无效或已过期");
            return false;
        }

        // 2. 从Token获取用户名，查询用户角色
        String username = JwtUtils.getUsernameFromToken(token);
        User user = userService.getUserByUsername(username); // 之前实现的根据用户名查询用户方法
        if (user == null) {
            response.setStatus(401);
            response.getWriter().write("用户不存在");
            return false;
        }
        String userRole = user.getRole(); // 获取用户实际角色（如"admin"或"operator"）

        // 3. 检查接口是否需要特定角色（通过@RequireRole注解）
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 如果接口标记了@RequireRole注解
            if (method.isAnnotationPresent(RequireRole.class)) {
                RequireRole requireRole = method.getAnnotation(RequireRole.class);
                String requiredRole = requireRole.value(); // 接口要求的角色
                // 角色不匹配则拦截
                if (!requiredRole.equals(userRole)) {
                    response.setStatus(403); // 禁止访问
                    response.getWriter().write("权限不足，需要" + requiredRole + "角色");
                    return false;
                }
            }
        }

        // 4. 验证通过，放行
        return true;
    }
}



