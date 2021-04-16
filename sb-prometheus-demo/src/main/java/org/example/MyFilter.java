package org.example;

import org.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = "/actuator/prometheus")
public class MyFilter implements Filter {

    @Autowired
    private MyService myService;

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        myService.onlineCount();

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
