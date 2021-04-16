package org.example.service;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AtomicDouble;
import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.search.Search;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.MyMeter;
import org.example.prometheus.MyMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

@Service
@Slf4j
public class MyService {

    @Autowired
    private MyMetrics myMetrics;

    public void onlineCount() {

        double count1 = new Random().nextDouble() * 2000;
        double count2 = new Random().nextDouble() * 2000;
        double count3 = new Random().nextDouble() * 2000;

        myMetrics.flushAll(Lists.newArrayList(
                new MyMeter("app_count1", Tags.of("k12", "v1"), count1),
                new MyMeter("app_count1", Tags.of("k12", "v2"), count2),
                new MyMeter("app_count2", Tags.of("k123", "v123"), count3)
                ));

        myMetrics.flushAll(Lists.newArrayList(
                new MyMeter("app_count1", Tags.of("k12", "v1"), count1),
                new MyMeter("app_count2", Tags.of("k123", "v123"), count3)
        ));

        log.info("finish");
    }

}
