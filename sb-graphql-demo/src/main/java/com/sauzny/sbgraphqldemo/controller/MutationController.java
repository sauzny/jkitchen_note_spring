package com.sauzny.sbgraphqldemo.controller;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sauzny.sbgraphqldemo.uitls.Greeting;

@Component
public class MutationController implements GraphQLMutationResolver {

    public Greeting newGreeting(String message) {
        Greeting greeting = new Greeting();
        greeting.setId("1");
        greeting.setMessage(message);
        return greeting;
    }
}
