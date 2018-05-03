package com.sauzny.springbootweb.controller.vo;

import lombok.Data;

@Data
public class RePassword {
    
    private Long userId;
    private String oldPassword;
    private String newPassword;
}
