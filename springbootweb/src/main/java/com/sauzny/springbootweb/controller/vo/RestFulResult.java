package com.sauzny.springbootweb.controller.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sauzny.springbootweb.SbwConstant.FailureEnum;
import com.sauzny.springbootweb.utils.JacksonUtils;

import static com.sauzny.springbootweb.SbwConstant.Result.*;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RestFulResult {
    
    // 业务状态代码 0正常 其他异常
    private Integer status;
    // 提示信息
    private String message;

    // 返回结果为对象类型时使用
    private Object entity;
    // 返回结果为数组类型时使用
    private List<?> list;
    // 分页时填充结果
    private PageContent<?> page;
    
    public static RestFulResult success(){
        RestFulResult result = new RestFulResult();
        result.setStatus(STATUS_SUCCESS);
        result.setMessage(MESSAGE_SUCCESS);
        return result;
    }
    
    public static RestFulResult success(Object entity){
        RestFulResult result = RestFulResult.success();
        result.setEntity(entity);
        return result;
    }
    
    public static RestFulResult success(List<?> list){
        RestFulResult result = RestFulResult.success();
        result.setList(list);
        return result;
    }
    
    public static RestFulResult success(PageContent<?> page){
        RestFulResult result = RestFulResult.success();
        result.setPage(page);
        return result;
    }
    
    public static RestFulResult failure(){
        RestFulResult result = new RestFulResult();
        result.setStatus(STATUS_FAILURE);
        result.setMessage(MESSAGE_FAILURE);
        return result;
    }
    
    public static RestFulResult failure(FailureEnum failureEnum){
        RestFulResult result = new RestFulResult();
        result.setStatus(failureEnum.getStatusCode());
        result.setMessage(failureEnum.getMessage());
        return result;
    }
    
    public static RestFulResult failure(Integer status, String message){
        RestFulResult result = new RestFulResult();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }
    
    public String toJson(){
        return JacksonUtils.nonNull().toJson(this);
    }
}
