package com.sauzny.sbgraphqldemo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    
    //@Bean
    /*
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        
        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
        registrationBean.setFilter(new JwtFilter());
        
        //添加需要拦截的url
        List<String>  urlPatterns = Lists.newArrayList();
        
        urlPatterns.add(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/isLogin");
        urlPatterns.add(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/logout");
        urlPatterns.add(SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/*");
        urlPatterns.add(SbwConstant.Controller.CLASSES_CONTROLLER_MAPPING+"/*");
        urlPatterns.add(SbwConstant.Controller.SCHOOL_CONTROLLER_MAPPING+"/*");

        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));

        //排除这个路径api/demand/gettypelist  
        registrationBean.addInitParameter("exclusions", "api/demand/gettypelist");  
        
        //spring boot 会按照order值的大小，从小到大的顺序来依次过滤。  
        registrationBean.setOrder(1);  
        
        return registrationBean;
    }
     */
    
 
}
