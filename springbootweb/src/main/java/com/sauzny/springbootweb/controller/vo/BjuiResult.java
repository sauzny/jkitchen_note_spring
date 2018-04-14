package com.sauzny.springbootweb.controller.vo;

import lombok.Data;

import static com.sauzny.springbootweb.SbwConstant.BjuiResult.*;

import java.util.List;

import com.sauzny.springbootweb.SbwConstant.FailureEnum;

@Data
public class BjuiResult extends RestFulResult{
    
    //  必选。状态码(ok = 200, error = 300, timeout = 301)，可以在BJUI.init时配置三个参数的默认值。
    private int statusCode;
    
    //  可选。信息内容。
    private String message;
    
    //  可选。待刷新navtab id，多个id以英文逗号分隔开，当前的navtab id不需要填写，填写后可能会导致当前navtab重复刷新。
    private String tabid;
    
    //  可选。待刷新dialog id，多个id以英文逗号分隔开，请不要填写当前的dialog id，要控制刷新当前dialog，请设置dialog中表单的reload参数。
    private String dialogid;
    
    //  可选。待刷新div id，多个id以英文逗号分隔开，请不要填写当前的div id，要控制刷新当前div，请设置该div中表单的reload参数。
    private String divid;
    
    //  可选。是否关闭当前窗口(navtab或dialog)。
    private boolean closeCurrent;
    
    //  可选。跳转到某个url。
    private String forward;
    
    //  可选。跳转url前的确认提示信息。
    private String forwardConfirm;
    
    public static BjuiResult bjuiResult(RestFulResult restFulResult){
        BjuiResult bjuiResult = new BjuiResult();
        bjuiResult.setStatus(restFulResult.getStatus());
        bjuiResult.setMessage(restFulResult.getMessage());
        bjuiResult.setEntity(restFulResult.getEntity());
        bjuiResult.setList(restFulResult.getList());
        bjuiResult.setPage(restFulResult.getPage());
        return bjuiResult;
    }
    
    public static BjuiResult ok(){
        BjuiResult ok = BjuiResult.bjuiResult(RestFulResult.success());
        ok.setStatusCode(STATUS_CODE_OK);
        return ok;
    }
    
    public static BjuiResult ok(Object entity){
        BjuiResult ok = BjuiResult.bjuiResult(RestFulResult.success(entity));
        ok.setStatusCode(STATUS_CODE_OK);
        return ok;
    }
    
    public static BjuiResult ok(List<?> list){
        BjuiResult ok = BjuiResult.bjuiResult(RestFulResult.success(list));
        ok.setStatusCode(STATUS_CODE_OK);
        return ok;
    }
    
    public static BjuiResult ok(PageContent<?> page){
        BjuiResult ok = BjuiResult.bjuiResult(RestFulResult.success(page));
        ok.setStatusCode(STATUS_CODE_OK);
        return ok;
    }
    
    public static BjuiResult error(){
        BjuiResult error = BjuiResult.bjuiResult(RestFulResult.failure());
        error.setStatusCode(STATUS_CODE_ERROR);
        return error;
    }
    
    public static BjuiResult error(FailureEnum failureEnum){
        BjuiResult error = BjuiResult.bjuiResult(RestFulResult.failure(failureEnum));
        error.setStatusCode(STATUS_CODE_ERROR);
        return error;
    }
    
    public static BjuiResult error(Integer status, String message){
        BjuiResult error = BjuiResult.bjuiResult(RestFulResult.failure(status, message));
        error.setStatusCode(STATUS_CODE_ERROR);
        return error;
    }
    
}
