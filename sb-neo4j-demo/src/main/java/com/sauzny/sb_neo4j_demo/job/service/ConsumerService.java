package com.sauzny.sb_neo4j_demo.job.service;

import java.util.List;

import org.assertj.core.util.Lists;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sauzny.sb_neo4j_demo.job.domain.Consumer;
import com.sauzny.sb_neo4j_demo.job.repo.ConsumerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {
    
    @Autowired
    private ConsumerRepository consumerRepository;

    // 相对底层的DAO操作，可以配合Filter使用
    @Autowired
    Session session;
    
    public void initData(){
        
        Consumer consumer01 = new Consumer("猩红女巫", 0);
        Consumer consumer02 = new Consumer("幻视", 1);
        Consumer consumer03 = new Consumer("奇异博士", 1);
        Consumer consumer04 = new Consumer("钢铁侠", 1);
        Consumer consumer05 = new Consumer("战争机器", 2);
        Consumer consumer06 = new Consumer("王", 2);
        Consumer consumer07 = new Consumer("蜘蛛侠", 2);
        Consumer consumer08 = new Consumer("蚁人", 2);
        Consumer consumer09 = new Consumer("黑豹", 2);
        Consumer consumer10 = new Consumer("美国队长", 2);
        Consumer consumer11 = new Consumer("猎鹰", 3);
        Consumer consumer12 = new Consumer("冬兵", 3);
        Consumer consumer13 = new Consumer("绿巨人", 3);
        Consumer consumer14 = new Consumer("黑寡妇", 3);
        Consumer consumer15 = new Consumer("鹰眼", 3);

        consumer01.setConsumers(Lists.newArrayList(consumer02, consumer03, consumer04));
        
        consumer02.setConsumers(Lists.newArrayList(consumer05, consumer06));
        consumer03.setConsumers(Lists.newArrayList(consumer07, consumer08));
        consumer04.setConsumers(Lists.newArrayList(consumer09, consumer10));
        
        consumer05.setConsumers(Lists.newArrayList(consumer11, consumer12));
        consumer07.setConsumers(Lists.newArrayList(consumer13, consumer14));
        consumer09.setConsumers(Lists.newArrayList(consumer15));
        
        consumerRepository.saveAll(Lists.newArrayList(
                consumer01,
                consumer02,
                consumer03,
                consumer04,
                consumer05,
                consumer06,
                consumer07,
                consumer08,
                consumer09,
                consumer10,
                consumer11,
                consumer12,
                consumer13,
                consumer14,
                consumer15
                ));
        
        log.info("增加节点");
    }

    
    public void cleanAll(){
        consumerRepository.deleteAll();
    }
    
    @Transactional
    public void updateByPrimaryKeySelective(Consumer consumer){
        
        Consumer target = consumerRepository.findById(consumer.getId()).orElse(null);
        
        if(consumer.getLevel() != null) target.setLevel(consumer.getLevel());
        if(consumer.getName() != null) target.setName(consumer.getName());
        if(consumer.getCreateTime() != null) target.setCreateTime(consumer.getCreateTime());
        if(consumer.getConsumers() != null) target.setConsumers(consumer.getConsumers());
        
        consumerRepository.save(target);
    }
    
    public void insert(Consumer consumer){
        //consumerRepository.save(consumer);
        consumerRepository.save(consumer, 3);
    }
    
    public void deleteByPrimaryKey(long id){
        consumerRepository.deleteById(id);
    }
    
    public Iterable<Consumer> findAllById(List<Long> ids, int depth){
        return consumerRepository.findAllById(ids, depth);
    }
    
    // 使用session查找
    public Iterable<Consumer> findByProperty(String propertyName, Object propertyValue) {
        return session.loadAll(Consumer.class, new Filter(propertyName, ComparisonOperator.EQUALS, propertyValue));
    }
    
    public List<Consumer> leadShortestPath(String mName, String nName){
        return consumerRepository.leadShortestPath(mName, nName);
    }
    
    public Consumer selectByPrimaryKey(long id){
        return consumerRepository.findById(id).orElse(null);
    }
}
