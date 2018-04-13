package com.sauzny.springbootweb.config;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.google.common.collect.Lists;
import com.sauzny.springbootweb.SbwConstant;

@Configuration
public class WebConfig {
    
    //@Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        
        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
        registrationBean.setFilter(new JwtFilter());
        
        //添加需要拦截的url
        List<String>  urlPatterns = Lists.newArrayList();
        urlPatterns.add(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/logout");
        urlPatterns.add(SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/*");
        urlPatterns.add(SbwConstant.Controller.CLASSES_CONTROLLER_MAPPING+"/*");
        urlPatterns.add(SbwConstant.Controller.SCHOOL_CONTROLLER_MAPPING+"/*");

        
        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
        
        return registrationBean;
    }

}
