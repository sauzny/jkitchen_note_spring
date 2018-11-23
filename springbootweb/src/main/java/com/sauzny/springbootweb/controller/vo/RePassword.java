package com.sauzny.springbootweb.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RePassword {

    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("sha512(用户旧密码)")
    private String oldPassword;
    @ApiModelProperty("sha512(用户新密码)")
    private String newPassword;
}
