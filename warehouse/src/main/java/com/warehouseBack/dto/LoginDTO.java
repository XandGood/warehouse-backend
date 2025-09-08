package com.warehouseBack.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "登录请求参数")
public class LoginDTO {
    @ApiModelProperty(value = "用户名", example = "admin", required = true)
    private String username;

    @ApiModelProperty(value = "密码", example = "admin123", required = true)
    private String password;
}
