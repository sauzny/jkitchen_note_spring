package org.example.prometheus;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Getter
@Slf4j
public class MyMetrics {

    @Autowired
    private MeterRegistry registry;

    @Getter
    private AtomicInteger count;

    @Getter
    private Timer timer;

    @PostConstruct
    public void init(){
        //this.registry.clear();
        Tags tags = Tags.of("key1", "value1", "key2", "value2");
        this.count = this.registry.gauge("app_online_count", tags, new AtomicInteger(0));
        this.timer = this.registry.timer("app_online_timer");
        List<Meter> meterList = this.registry.getMeters();
        log.info("meterList : {}", meterList.size());
    }

}
