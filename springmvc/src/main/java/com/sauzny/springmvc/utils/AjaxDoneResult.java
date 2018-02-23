package com.sauzny.springmvc.utils;

import lombok.Data;

@Data
public class AjaxDoneResult {
    
    private String statusCode;
    private String message;
    private String navTabId;
    private String callbackType;
    private String forwardUrl;

}
