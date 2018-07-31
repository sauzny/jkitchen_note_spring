package com.sauzny.sbgraphqldemo.controller;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sauzny.sbgraphqldemo.uitls.Greeting;

@Component
public class QueryController implements GraphQLQueryResolver {

    public Greeting getGreeting(String id) {
        Greeting greeting = new Greeting();
        greeting.setId("1");
        greeting.setMessage("哈哈");
        return greeting;
    }
}
