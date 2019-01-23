package com.sauzny.sbshirodemo.system;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;
import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.system.jwt.JwtFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

    // jwtFilter 在 shiroFilter 中配置使用
    /*
    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {

        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
        registrationBean.setFilter(new JwtFilter());

        //添加需要拦截的url
        List<String>  urlPatterns = Lists.newArrayList();
        urlPatterns.add(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/logout");
        urlPatterns.add(SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/*");

        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));

        //排除这个路径api/demand/gettypelist
        registrationBean.addInitParameter("exclusions", "api/demand/gettypelist");

        //spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
        registrationBean.setOrder(2);

        return registrationBean;
    }
    */

}
