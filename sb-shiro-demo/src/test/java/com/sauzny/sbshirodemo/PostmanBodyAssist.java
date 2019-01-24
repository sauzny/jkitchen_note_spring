package com.sauzny.sbshirodemo;

import com.sauzny.sbshirodemo.controller.vo.User4Passport;
import com.sauzny.sbshirodemo.utils.JacksonUtils;
import org.junit.Test;

/***************************************************************************
 *
 * @时间: 2019/1/24 - 10:52
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class PostmanBodyAssist {

    private static void printJson(Object object){
        System.out.println(JacksonUtils.nonEmpty().toJson(object));
    }

    @Test
    public void login(){
        User4Passport user = new User4Passport();
        user.setUserName("zhangsan");
        user.setPassword("zhangsan");
        printJson(user);
    }
}
