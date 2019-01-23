package com.sauzny.sbshirodemo;

import com.sauzny.sbshirodemo.controller.vo.RestFulResult;
import com.sauzny.sbshirodemo.utils.JacksonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/***************************************************************************
 *
 * @时间: 2019/1/21 - 16:22
 *
 * @描述: TODO
 *
 ***************************************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WebTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;

    private void simpleGet(final String urlTemplate) throws Exception{
        getWithHead(urlTemplate, new HttpHeaders());
    }

    private void getWithHead(final String urlTemplate, final HttpHeaders httpHeaders) throws Exception{
        this.mockMvc.perform(
                get(urlTemplate)
                        .headers(httpHeaders)
                        .contentType(MediaType.APPLICATION_JSON) // 设置 http 请求内容类型
                        .characterEncoding("UTF-8") // 设置请求编码
                        .accept(MediaType.APPLICATION_JSON) // 设置请求数据类型为 json
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print());

    }

    @Before
    public void setup() {
        // init applicationContext
        this.mockMvc = webAppContextSetup(wac).build();
        this.session = new MockHttpSession();
    }

    @Test
    public void jwtTest() throws Exception {
        simpleGet(SbwConstant.Controller.USER_CONTROLLER_MAPPING + "/userList");
        simpleGet(SbwConstant.Controller.USER_CONTROLLER_MAPPING + "/userOne");
        simpleGet(SbwConstant.Controller.USER_CONTROLLER_MAPPING + "/help");
    }

    @Test
    public void demo() throws Exception {

        // 登录 正确的账号密码 获取token
        MvcResult loginResult = this.mockMvc.perform(
                (post("/passport/login"))
                        .contentType(MediaType.APPLICATION_JSON) // 设置 http 请求内容类型
                        .characterEncoding("UTF-8") // 设置请求编码
                        .accept(MediaType.APPLICATION_JSON) // 设置请求数据类型为 json
                        .param("username", "zhangsan") // 设置请求传递的参数
                        .param("password", "zhangsan")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();
        //.andDo(print());

        RestFulResult loginRestFulResult = JacksonUtils.nonEmpty().fromJson(loginResult.getResponse().getContentAsString(), RestFulResult.class);

        String token = loginRestFulResult.getObject().toString();

        System.out.println(token);

        // 带有token访问接口
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(SbwConstant.Jwt.TOKEN, token);
        getWithHead(SbwConstant.Controller.USER_CONTROLLER_MAPPING + "/userList", httpHeaders);
        getWithHead(SbwConstant.Controller.USER_CONTROLLER_MAPPING + "/userOne", httpHeaders);

    }
}
