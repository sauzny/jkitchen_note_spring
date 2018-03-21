package com.sauzny.springbootweb;

public interface SbwConstant {

    interface Controller{
        String API_PREFIX = "/api";
        String HEALTH_CONTROLLER_MAPPING = API_PREFIX + "/health";
        String PASSPORT_CONTROLLER_MAPPING = API_PREFIX + "/passport";
        String USER_CONTROLLER_MAPPING = API_PREFIX + "/users";
        String PRODUCT_CONTROLLER_MAPPING = API_PREFIX + "/products";
        String ORDERINFO_CONTROLLER_MAPPING = API_PREFIX + "/orderInfos";
    }
    
    interface Platform{
        int JFS = 1;
        int SH = 2;
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
        // 商户
        int MERCHANT = 2;
        // 采购员
        int PURCHASE = 3;
    }
    
    interface OrderInfoState{

        // 1待审核
        int DSHE = 1;
        // 2待发货(审核通过)
        int DFH = 2;
        // 3待收货(导入卡密)
        int DSHUO = 3;
        // 4待下发(收货)
        int DXF = 4;
        // 5待下载
        int DXZ = 5;
        // 6已下载
        int YXZ = 6;
        // 7已关闭
        int YGB = 7;
    }
    
    interface ProductState{
        
        // 1分销中
        int FXZ = 1;
        // 2待分销
        int DFX = 2;
        
        String[] ZH = {"", "分销中", "待分销"};
    }
    
    interface RestFulResult{
        
        int STATUS_CODE_SUCCESS = 0;
        String MESSAGE_SUCCESS  = "操作成功";
        int STATUS_CODE_FAILURE = 99999;
        String MESSAGE_FAILURE = "操作失败";
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
        
         // 2000+ productFailure ==================
        PRODUCT_NAME_EMPTY(2001, "请填写商品名称"),
        PRODUCT_NUM_EMPTY(2002, "请填写供应商商品编号"),
        PRODUCT_PURCHASE_PRICE_EMPTY(2003, "请填写采购价"),
        PRODUCT_PURCHASE_PRICE_ILLEGAL(2004, "采购价填写错误"),
        PRODUCT_DISTRIBUTION_PRICE_EMPTY(2005, "请填写分销价"),
        PRODUCT_DISTRIBUTION_PRICE_ILLEGAL(2006, "分销价填写错误"),
        
         // 3000+ orderFailure ==================
        ORDER_SEND_EXPIRY_DATE_EMPTY(3001, "请填写有效期"),
        ORDER_SEND_EXPIRY_DATE_ILLEGAL(3002, "有效期填写错误"),
        ORDER_SEND_TICKET_EMPTY(3003, "请上传卡密"),
        ORDER_SEND_TICKET_ILLEGAL(3004, "卡密格式不正确"),
        ORDER_SEND_TICKET_AMOUNT_ILLEGAL(3005, "卡密数量与订单数量不符"),
        
        ORDER_APPLY_NUM_EMPTY(3006, "请填写商品编号"),
        ORDER_APPLY_COUNT_EMPTY(3007, "请填写采购数量"),
        ORDER_APPLY_COUNT_ILLEGAL(3008, "采购数量超过限制"),
        
         // 4000+ merchantFailure ==================
        MERCHANT_ACCOUNT_ILLEGAL(4001, "登录名需为4-16个字符"),
        MERCHANT_ACCOUNT_REPEAT(4002, "该登录名已存在"),
        
        MERCHANT_COMPANY_EMPTY(4003, "请填写公司名称"),
        MERCHANT_CONTACT_EMPTY(4004, "请填写联系人"),
        MERCHANT_PHONE_REPEAT(4005, "请填写手机号"),
        MERCHANT_PHONE_ILLEGAL(4006, "请填写正确的手机号"),
        MERCHANT_ACCOUNT_EMPTY(4007, "请填写登录名"),
        //MERCHANT_ACCOUNT_ILLEGAL(4008, "登录名需为4-16个字符"),
        //MERCHANT_ACCOUNT_REPEAT(4009, "该登录名已存在"),
        MERCHANT_PASSWORD1_EMPTY(4010, "请输入密码"),
        MERCHANT_PASSWORD2_EMPTY(4011, "请确认密码"),
        MERCHANT_PASSWORD1_ILLEGAL(4012, "密码格式不符合要求"),
        MERCHANT_PASSWORD12_NOT_MATCH(4013, "两次输入的密码不一致，请重新输入"),

        MERCHANT_RESET_PASSWORD_EMPTY(4014, "请输入密码"),
        MERCHANT_RESET_PASSWORD_NOT_MATCH(4015, "原密码错误，请重新输入"),
        MERCHANT_RESET_PASSWORD1_EMPTY(4016, "请输入新密码"),
        MERCHANT_RESET_PASSWORD2_EMPTY(4017, "请确认新密码"),
        MERCHANT_RESET_PASSWORD1_ILLEGAL(4018, "新密码格式不符合要求"),
        MERCHANT_RESET_PASSWORD12_NOT_MATCH(4019, "两次输入的新密码不一致，请重新输入"),
        
        
         // 5000+ subaccountFailure ==================
        SUBACCOUNT_ACCOUNT_ILLEGAL(5001, "登录名需为4-16个字符"),
        SUBACCOUNT_ACCOUNT_REPEAT(5002, "该登录名已存在"),

        SUBACCOUNT_DEPARTMENT_EMPTY(5003, "请填写部门信息"),
        SUBACCOUNT_CONTACT_EMPTY(5004, "请填写联系人"),
        SUBACCOUNT_PHONE_REPEAT(5005, "请填写手机号"),
        SUBACCOUNT_PHONE_ILLEGAL(5006, "请填写正确的手机号"),
        SUBACCOUNT_ACCOUNT_EMPTY(5007, "请填写登录名"),
        // SUBACCOUNT_ACCOUNT_ILLEGAL(5008, "登录名需为4-16个字符"),
        // SUBACCOUNT_ACCOUNT_REPEAT(5009, "该登录名已存在"),
        SUBACCOUNT_PASSWORD1_EMPTY(5010, "请输入密码"),
        SUBACCOUNT_PASSWORD2_EMPTY(5011, "请确认密码"),
        SUBACCOUNT_PASSWORD1_ILLEGAL(5012, "密码格式不符合要求"),
        SUBACCOUNT_PASSWORD12_NOT_MATCH(5013, "两次输入的密码不一致，请重新输入"),

        SUBACCOUNT_RESET_PASSWORD1_EMPTY(5014, "请输入密码"),
        SUBACCOUNT_RESET_PASSWORD2_EMPTY(5015, "请确认密码"),
        SUBACCOUNT_RESET_PASSWORD1_ILLEGAL(5016, "密码格式不符合要求"),
        SUBACCOUNT_RESET_PASSWORD12_NOT_MATCH(5017, "两次输入的密码不一致，请重新输入"),
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
