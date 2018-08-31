package com.sauzny.sbwebfluxdemo.controller.vo;

import static com.sauzny.sbwebfluxdemo.SbwfConstant.Result.MESSAGE_FAILURE;
import static com.sauzny.sbwebfluxdemo.SbwfConstant.Result.MESSAGE_SUCCESS;
import static com.sauzny.sbwebfluxdemo.SbwfConstant.Result.STATUS_FAILURE;
import static com.sauzny.sbwebfluxdemo.SbwfConstant.Result.STATUS_SUCCESS;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sauzny.sbwebfluxdemo.SbwfConstant.FailureEnum;
import com.sauzny.sbwebfluxdemo.utils.JacksonUtils;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@JsonInclude(Include.NON_NULL)
public class WebFluxResult {
	
    // 业务状态代码 0正常 其他异常
    private Integer status;
    // 提示信息
    private String message;

    // 返回结果为对象类型时使用
    private Mono<?> mono;
    
    // 返回结果为数组类型时使用
    private Flux<?> flux;
    
    public static WebFluxResult success(){
        WebFluxResult result = new WebFluxResult();
        result.setStatus(STATUS_SUCCESS);
        result.setMessage(MESSAGE_SUCCESS);
        return result;
    }
    
    public static WebFluxResult success(Mono<?> mono){
        WebFluxResult result = WebFluxResult.success();
        result.setMono(mono);
        return result;
    }
    
    public static WebFluxResult success(Flux<?> flux){
        WebFluxResult result = WebFluxResult.success();
        result.setFlux(flux);
        return result;
    }
    /*
    public static WebFluxResult success(PageContent<?> page){
        WebFluxResult result = WebFluxResult.success();
        result.setPage(page);
        return result;
    }
    */
    public static WebFluxResult failure(){
        WebFluxResult result = new WebFluxResult();
        result.setStatus(STATUS_FAILURE);
        result.setMessage(MESSAGE_FAILURE);
        return result;
    }
    
    public static WebFluxResult failure(FailureEnum failureEnum){
        WebFluxResult result = new WebFluxResult();
        result.setStatus(failureEnum.getStatusCode());
        result.setMessage(failureEnum.getMessage());
        return result;
    }
    
    public static WebFluxResult failure(Integer status, String message){
        WebFluxResult result = new WebFluxResult();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }
    
    public String toJson(){
        return JacksonUtils.nonNull().toJson(this);
    }
    
    public Mono<WebFluxResult> toMono(){
    	return Mono.just(this);
    }
}
