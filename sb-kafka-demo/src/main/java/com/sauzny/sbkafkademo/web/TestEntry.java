package com.sauzny.sbkafkademo.web;

import com.sauzny.sbkafkademo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEntry {


    @Autowired
    private SendMessage<Integer, String> sendMessage;

    @GetMapping("/send1/{name}")
    public void send1(@PathVariable String name){
        sendMessage.asyncSend("ljx_topic1", 1, name);
    }

    @GetMapping("/send2/{name}")
    public void send2(@PathVariable String name){
        sendMessage.syncSend("ljx_topic2", 2, name);
        sendMessage.syncSend("ljx_topic3", 3, name);

    }
}
