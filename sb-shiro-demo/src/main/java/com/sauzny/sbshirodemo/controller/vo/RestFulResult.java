package com.sauzny.sbshirodemo.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sauzny.sbshirodemo.SbwConstant.FailureEnum;
import com.sauzny.sbshirodemo.utils.JacksonUtils;

import static com.sauzny.sbshirodemo.SbwConstant.Result.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RestFulResult {

    @ApiModelProperty("业务状态代码 0正常 其他异常")
    private Integer code;
    @ApiModelProperty("异常情况下的提示信息")
    private String message;
    @ApiModelProperty("正常情况下返回的业务数据")
    private Object object;
    
    public static RestFulResult success(){
        RestFulResult result = new RestFulResult();
        result.setCode(STATUS_SUCCESS);
        result.setMessage(MESSAGE_SUCCESS);
        return result;
    }
    
    public static RestFulResult success(Object object){
        RestFulResult result = RestFulResult.success();
        result.setObject(object);
        return result;
    }

    
    public static RestFulResult failure(){
        RestFulResult result = new RestFulResult();
        result.setCode(STATUS_FAILURE);
        result.setMessage(MESSAGE_FAILURE);
        return result;
    }
    
    public static RestFulResult failure(FailureEnum failureEnum){
        RestFulResult result = new RestFulResult();
        result.setCode(failureEnum.getStatusCode());
        result.setMessage(failureEnum.getMessage());
        return result;
    }
    
    public static RestFulResult failure(Integer status, String message){
        RestFulResult result = new RestFulResult();
        result.setCode(status);
        result.setMessage(message);
        return result;
    }
    
    public String toJson(){
        return JacksonUtils.nonNull().toJson(this);
    }
}
