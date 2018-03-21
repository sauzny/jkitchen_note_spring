package com.sauzny.springbootweb.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.controller.vo.RestFulResult;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private RestFulResult runtimeExceptionHandler(Exception e) {
        log.error("runtime error {}", e.getMessage());
        log.debug("", e);
        return RestFulResult.failure();
    }

    
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private RestFulResult dataIntegrityViolationExceptionHandler(DataIntegrityViolationException e) {
        log.error("DataIntegrityViolationException wtite db error {}", e.getMessage());
        log.debug("", e);
        return RestFulResult.failure(SbwConstant.FailureEnum.DB_DATA_ILLEGAL);
    }

}

