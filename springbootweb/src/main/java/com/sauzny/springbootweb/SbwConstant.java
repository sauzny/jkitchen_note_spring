package com.sauzny.springbootweb;

import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

public interface SbwConstant {

    interface Controller{
        
        String CAPTCHA = "SBW_CAPTCHA";

        String SYS_CONTROLLER_MAPPING = "/sys";
        String PASSPORT_CONTROLLER_MAPPING = "/passport";
        String USER_CONTROLLER_MAPPING = "/users";
        String ROLE_CONTROLLER_MAPPING = "/roles";
    }
    
    interface Jwt{
        String TOKEN = "X-Token";
        String JTI = "jti";
        String EXP = "exp";
        String USER_ID = "userId";
        String USER_NAME = "userName";
        String ACCOUNT = "account";
        String JUMP_TOKEN = "jump";
    }

    interface UserRole{

        // 管理员
        int MANAGER = 1;
        // 老师
        int TEACHER = 2;
        // 学生
        int STUDENT = 3;

        String[] ZH = {"", "管理员", "老师", "学生"};
    }

    enum UserRoleEnum {

        @ApiModelProperty("1 管理员")
        MANAGER(1, "管理员"),

        @ApiModelProperty("2 老师")
        TEACHER(2, "老师"),

        @ApiModelProperty("3 学生")
        STUDENT(3, "学生"),
        ;

        private int code;
        private String zh;

        // 构造方法必须是私有的
        private UserRoleEnum(int code, String zh) {
            this.code = code;
            this.zh = zh;
        }

        public int getCode(){
            return this.code;
        }

        public String getZh(){
            return this.zh;
        }

        public Map<String, Object> toMap() {
            return ImmutableMap.<String, Object>builder()
                    .put("code", code)
                    .put("zh", zh)
                    .build();
        }
    }

    ///////////////////////////////////////////////////

    interface Result {
        
        int STATUS_SUCCESS = 0;
        String MESSAGE_SUCCESS  = "操作成功";
        
        int STATUS_FAILURE = 99999;
        String MESSAGE_FAILURE = "操作失败";
    }

    enum FailureEnum {

        @ApiModelProperty("99998 输入数据不符合要求")
        DB_DATA_ILLEGAL(99998, "输入数据不符合要求"),
        ACCESS_ILLEGAL(99997, "访问非法"),
        LOGIC_ILLEGAL(99996, "逻辑非法"),
        
        
        // 1000+ loginFailure ==================
        LOGIN_ACCOUNT_EMPTY(1001, "请输入用户名"),
        LOGIN_PASSWORD_EMPTY(1002, "请输入密码"),
        LOGIN_NOT_MATCH(1003, "用户名或密码错误"),
        TOKEN_ILLEGAL(1004, "请重新登录"),
        CAPTCHA_EMPTY(1005, "验证码为空"),
        CAPTCHA_ILLEGAL(1006, "请重新登录"),

        // 2000+ userFailure ==================
        USER_RESET_PASSWORD_NOT_MATCH(2001, "原密码错误，请重新输入"),
        
        ;
        
        private int statusCode;
        private String message;
        
        // 构造方法必须是私有的
        private FailureEnum(int statusCode, String message) { 
            this.statusCode = statusCode;
            this.message = message;
        }
        
        public int getStatusCode(){
            return this.statusCode;
        }
        
        public String getMessage(){
            return this.message;
        }

    }
    
}
