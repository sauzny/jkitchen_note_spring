package com.sauzny.springbootweb.controller;

import static com.sauzny.springbootweb.SbwConstant.Controller.SYS_CONTROLLER_MAPPING;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sauzny.springbootweb.utils.CaptchaUtil;
import com.sauzny.springbootweb.utils.ControllerUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value=SYS_CONTROLLER_MAPPING)
@Slf4j
public class SysController {

    // 健康检查
    @RequestMapping(value = "/health", method = { RequestMethod.HEAD })
    public void check() {
        log.debug("health check");
    }

    // 生成验证码
    @RequestMapping(value = "/captcha")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        // 实际业务时，每次生成验证码时比较好费时间的，可以提前生成好
        Object[] imageAndCode = CaptchaUtil.getCaptchaImage();
        ControllerUtils.exportCaptcha(request, response, imageAndCode);//输出验证码图片方法
    }


}
