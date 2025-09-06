package com.warehouseBack.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "User", description = "用户信息实体")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名", example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", example = "admin123")
    private String password;

    @ApiModelProperty(value = "用户姓名", example = "张三")
    private String name;

    @ApiModelProperty(value = "用户角色", example = "admin")
    private String role;

    @ApiModelProperty(value = "用户号码",example = "13800138000")
    private String phone;

    @ApiModelProperty(value = "创建时间", example = "2025-09-06 12:00:00")
    private LocalDateTime create_time;


}
