package com.sauzny.sbvalidationdemo.controller;

import com.sauzny.sbvalidationdemo.entity.Foo01;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/***************************************************************************
 *
 * @时间: 2019/1/30 - 17:30
 *
 * @描述: TODO
 *
 ***************************************************************************/
@RestController
public class Foo01Controller {


    // http://localhost:8080/v001?age=2&phone=13566778899&email=abc@yahoo.com
    @GetMapping("/v001")
    public Object v001(@Validated Foo01 foo01, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return bindingResult.getAllErrors();
        }

        return "ok";
    }

    // 测试结果
    /*
    [
    {
        "codes": [
            "Min.foo01.age",
            "Min.age",
            "Min.java.lang.Integer",
            "Min"
        ],
        "arguments": [
            {
                "codes": [
                    "foo01.age",
                    "age"
                ],
                "arguments": null,
                "defaultMessage": "age",
                "code": "age"
            },
            18
        ],
        "defaultMessage": "最小不能小于18",
        "objectName": "foo01",
        "field": "age",
        "rejectedValue": 2,
        "bindingFailure": false,
        "code": "Min"
    },
    {
        "codes": [
            "NotBlank.foo01.name",
            "NotBlank.name",
            "NotBlank.java.lang.String",
            "NotBlank"
        ],
        "arguments": [
            {
                "codes": [
                    "foo01.name",
                    "name"
                ],
                "arguments": null,
                "defaultMessage": "name",
                "code": "name"
            }
        ],
        "defaultMessage": "不能为空",
        "objectName": "foo01",
        "field": "name",
        "rejectedValue": null,
        "bindingFailure": false,
        "code": "NotBlank"
    }
]
     */

    // 定义了分组校验，则只能按照Adult分组去校验，没有设置Adult分组的属性是不被校验的
    // http://localhost:8080/v002?age=2&phone=13566778899&email=abc@yahoo.com
    @GetMapping("/v002")
    public Object v002(@Validated({Foo01.Adult.class}) Foo01 foo01, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return bindingResult.getAllErrors();
        }

        return "ok";
    }

    /*
    [
    {
        "codes": [
            "Min.foo01.age",
            "Min.age",
            "Min.java.lang.Integer",
            "Min"
        ],
        "arguments": [
            {
                "codes": [
                    "foo01.age",
                    "age"
                ],
                "arguments": null,
                "defaultMessage": "age",
                "code": "age"
            },
            18
        ],
        "defaultMessage": "最小不能小于18",
        "objectName": "foo01",
        "field": "age",
        "rejectedValue": 2,
        "bindingFailure": false,
        "code": "Min"
    }
]
     */
}
