package com.sauzny.springboot01testing;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppTest {

    @Test
    public void foo01() {

        long stopTime = System.currentTimeMillis()+5*60*1000;
        
        ExecutorService service = Executors.newFixedThreadPool(1);
        
        for(int i=0; i<1; i++){
            service.execute(new Worker(stopTime));
        }
        
        while(true){
            
        }
    }
}

class Worker implements Runnable{
    
    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    private long stopTime;
    
    public Worker(long stopTime){
        this.stopTime = stopTime;
    }
    
    @Override
    public void run() {

        String url = "wss://localhost:8443/websocket";
        
        SecureClientSocket secureClientSocket = new SecureClientSocket();
        
        Session session = secureClientSocket.buildSession(url);
        
        try {
            
            while(System.currentTimeMillis() < stopTime){
                
                //System.out.println(System.currentTimeMillis() + " | " + stopTime);
                
                int sleepTime = RandomUtils.nextInt(0,1500);
                
                //Thread.sleep(sleepTime);
                
                String message = RandomStringUtils.randomAlphabetic(32);
                
                session.getRemote().sendString(message);
                
                logger.info(message);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}

