package com.sauzny.springboot01.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sauzny.springboot01.service.CompleteMessageService;

@RestController
@RequestMapping("/api/v1.0/message")
public class MessageController {

    @Autowired
    private CompleteMessageService completeMessageService;
    
    @ResponseBody
    @RequestMapping("/unPushedList/{username}")
    public String unPushedList(@PathVariable("username") String userName) {
        
        List<String> list = completeMessageService.getUnPushedMessage(userName);
        
        ObjectMapper mapper = new ObjectMapper();
        
        String jsonlist = "";
        
        try {
            jsonlist = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return jsonlist;
    }
    
    @ResponseBody
    @RequestMapping("/pushedList/{username}")
    public String pushedList(@PathVariable("username") String userName) {
        
        List<String> list = completeMessageService.getPushedMessage(userName);
        
        Collections.reverse(list);
        
        ObjectMapper mapper = new ObjectMapper();
        
        String jsonlist = "";
        
        try {
            jsonlist = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return jsonlist;
    }
}
