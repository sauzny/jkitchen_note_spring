package org.example.prometheus;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AtomicDouble;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.search.Search;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.MyMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Getter
@Slf4j
public class MyMetrics {

    private ConcurrentHashMap<Meter.Id, AtomicDouble> map = new ConcurrentHashMap<>();

    @Autowired
    private MeterRegistry registry;

    public void flushAll(List<MyMeter> MyMeterList){

        List<Meter.Id> removeMeterIdList = Lists.newArrayList(map.keySet());

        MyMeterList.forEach(myMeter -> {
            // 保留的id
            Meter.Id id = this.save(myMeter.getName(), myMeter.getTags(), myMeter.getValue());
            removeMeterIdList.remove(id);
        });

        // 删除不需要的id
        removeMeterIdList.forEach(id -> {
            this.map.remove(id);
            this.registry.remove(id);
        });
    }

    public Meter.Id save(String name, Tags tags, double value) {
        Meter.Id id = null;
        Gauge gauge = this.registry.find(name).tags(tags).gauge();
        if (gauge == null) {
            // 新建
            AtomicDouble number = this.registry.gauge(name, tags, new AtomicDouble(value));
            id = this.registry.find(name).tags(tags).gauge().getId();
            this.map.put(id, number);
        } else {
            // 修改
            id = gauge.getId();
            AtomicDouble number = this.map.get(id);
            number.set(value);
        }
        return id;
    }

}
