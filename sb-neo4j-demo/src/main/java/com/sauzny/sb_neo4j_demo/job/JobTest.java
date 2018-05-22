package com.sauzny.sb_neo4j_demo.job;

import java.util.List;

import javax.annotation.PostConstruct;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.sb_neo4j_demo.job.domain.Consumer;
import com.sauzny.sb_neo4j_demo.job.service.ConsumerService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobTest {

    @Autowired
    private ConsumerService consumerService;
    
    @PostConstruct
    public void foo01(){
        
        // 清楚数据
        //consumerService.cleanAll();
        
        // 初始化数据
        //consumerService.initData();
        
        // 修改
        /*
        consumerService.deleteByPrimaryKey(99L);
        
        Consumer consumer01 = new Consumer();
        consumer01.setName("灭霸");
        consumer01.setLevel(0);
        consumerService.insert(consumer01);
        */
        
        // 获取某个个节点下的元素，指定深度
        // -1 最大深度
        /*
        List<Consumer> consumers_1 = Lists.newArrayList(consumerService.findAllById(Lists.newArrayList(79L), -1));
        List<Consumer> consumers0 = Lists.newArrayList(consumerService.findAllById(Lists.newArrayList(85L), 0));
        List<Consumer> consumers1 = Lists.newArrayList(consumerService.findAllById(Lists.newArrayList(85L), 1));
        List<Consumer> consumers2 = Lists.newArrayList(consumerService.findAllById(Lists.newArrayList(85L), 2));

        log.info("consumers_1 : {}", consumers_1);
        log.info("consumers0 : {}", consumers0);
        log.info("consumers1 : {}", consumers1);
        log.info("consumers2 : {}", consumers2);
        */
        
        // 两点间最短路径
        List<Consumer> consumers = consumerService.leadShortestPath("冬兵", "猩红女巫");
        log.info("consumers : {}", consumers);
        
        consumers.forEach(System.out::println);
    }
}
