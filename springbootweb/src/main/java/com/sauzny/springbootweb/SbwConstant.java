package com.sauzny.springbootweb;

public interface SbwConstant {

    interface Controller{
        
        String CAPTCHA = "SBW_CAPTCHA";
        
        String API_PREFIX = "/api";
        String SYS_CONTROLLER_MAPPING = API_PREFIX + "/sys";
        String MENU_CONTROLLER_MAPPING = API_PREFIX + "/menu";
        String PASSPORT_CONTROLLER_MAPPING = API_PREFIX + "/passport";
        String USER_CONTROLLER_MAPPING = API_PREFIX + "/users";
        String CLASSES_CONTROLLER_MAPPING = API_PREFIX + "/classes";
        String SCHOOL_CONTROLLER_MAPPING = API_PREFIX + "/school";
    }
    
    interface Jwt{
        String TOKEN = "token";
        String JTI = "jti";
        String EXP = "exp";
        String USER_ID = "userId";
        String USER_NAME = "userName";
        String ROLE_ID = "roleId";
        String ACCOUNT = "account";
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


    interface Result {
        
        int STATUS_SUCCESS = 0;
        String MESSAGE_SUCCESS  = "操作成功";
        
        int STATUS_FAILURE = 99999;
        String MESSAGE_FAILURE = "操作失败";
    }
    
    interface BjuiResult {
        
         int STATUS_CODE_OK = 200; 
         String MESSAGE_OK  = "操作成功";
         
         int STATUS_CODE_ERROR = 300; 
         String MESSAGE_ERROR  = "操作失败";
         
         int STATUS_CODE_TIMEOUT = 301; 
         String MESSAGE_TIMEOUT  = "需要重新登录";
         
    }
    
    public enum FailureEnum {

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
