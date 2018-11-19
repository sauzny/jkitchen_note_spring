package com.sauzny.springbootweb.system;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;
import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.system.bodyreader.BodyReaderHttpServletRequestWrapperFilter;
import com.sauzny.springbootweb.system.jwt.JwtFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig {
    
	@Bean
	public FilterRegistrationBean<BodyReaderHttpServletRequestWrapperFilter> bodyReaderHttpServletRequestWrapperFilter(){
		final FilterRegistrationBean<BodyReaderHttpServletRequestWrapperFilter> registrationBean = new FilterRegistrationBean<BodyReaderHttpServletRequestWrapperFilter>();
        registrationBean.setFilter(new BodyReaderHttpServletRequestWrapperFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); 
        return registrationBean;
	}

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

	
    //@Bean
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
        registrationBean.setOrder(2);  
        
        return registrationBean;
    }

}
