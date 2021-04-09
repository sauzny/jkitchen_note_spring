package org.example.service;

import org.example.prometheus.MyMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.locks.LockSupport;

@Service
public class MyService {

    @Autowired
    private MyMetrics myMetrics;

    @PostConstruct
    public void init() {
        new Thread(() -> {
            this.unlimitedLoops();
        }, "unlimitedLoops").start();
    }

    public void unlimitedLoops() {
        while (true) {

            this.onlineCount();
            this.onlineTimer();

            // 睡眠 1 秒
            LockSupport.parkNanos(Duration.ofSeconds(1).toNanos());
        }
    }

    public void onlineCount() {
        int count = new Random().nextInt(2000);
        myMetrics.getCount().set(count);
    }

    public void onlineTimer() {
        int timer = new Random().nextInt(2000);
        myMetrics.getTimer().record(Duration.ofMillis(timer));
    }
}
