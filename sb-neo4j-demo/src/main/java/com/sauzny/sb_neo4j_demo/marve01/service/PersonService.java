package com.sauzny.sb_neo4j_demo.marve01.service;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.sb_neo4j_demo.marve01.domain.Person;
import com.sauzny.sb_neo4j_demo.marve01.repo.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public void initData(){
        
        Person person01 = new Person("猩红女巫");
        Person person02 = new Person("幻视");
        Person person03 = new Person("奇异博士");
        Person person04 = new Person("钢铁侠");
        Person person05 = new Person("战争机器");
        Person person06 = new Person("王");
        Person person07 = new Person("蜘蛛侠");
        Person person08 = new Person("蚁人");
        Person person09 = new Person("黑豹");
        Person person10 = new Person("美国队长");
        Person person11 = new Person("猎鹰");
        Person person12 = new Person("冬兵");
        Person person13 = new Person("绿巨人");
        Person person14 = new Person("黑寡妇");
        Person person15 = new Person("鹰眼");
        
        // Neo4j并不支持双向或者无向的关系
        // Neo4j的API允许开发人员在查询的时候完全忽略关系的方向
        // 在Neo4j中，遍历关系的任何一个方向所需的时间是相同的。进一步说，方向可以被完全忽略。
        // 因此，当单向的关系可以同时代表另一个方向的关系的时候，没有必要同时创建两个方向的关系。
        
        person01.setFriends(Lists.newArrayList(person02));
        //person01.setTeammates(Lists.newArrayList(person10));

        //person02.setFriends(Lists.newArrayList(person01));
        //person02.setTeammates(Lists.newArrayList(person04));
        
        //person03.setTeammates(Lists.newArrayList(person04));
        person03.setBrothers(Lists.newArrayList(person06));
        
        person04.setTeammates(Lists.newArrayList(person02, person03, person07));
        person04.setBrothers(Lists.newArrayList(person05, person10));
        
        //person05.setBrothers(Lists.newArrayList(person04));
        
        //person06.setBrothers(Lists.newArrayList(person03));
        
        //person07.setTeammates(Lists.newArrayList(person04));
        
        //person08.setTeammates(Lists.newArrayList(person10, person11));
        
        //person09.setTeammates(Lists.newArrayList(person10));
        
        person10.setTeammates(Lists.newArrayList(person01, person08, person09, person11, person13, person14, person15));
        person10.setBrothers(Lists.newArrayList(/*person04,*/ person12));
        
        //person11.setTeammates(Lists.newArrayList(person08, person10));
        
        //person12.setBrothers(Lists.newArrayList(person10));
        
        //person13.setFriends(Lists.newArrayList(person14));
        //person13.setTeammates(Lists.newArrayList(person10));
        
        person14.setFriends(Lists.newArrayList(person13, person15));
        //person14.setTeammates(Lists.newArrayList(person10));
        
        //person15.setFriends(Lists.newArrayList(person14));
        //person15.setTeammates(Lists.newArrayList(person10));
        
        personRepository.saveAll(Lists.newArrayList(
                person01,
                person02,
                person03,
                person04,
                person05,
                person06,
                person07,
                person08,
                person09,
                person10,
                person11,
                person12,
                person13,
                person14,
                person15
                ));
        
        log.info("增加节点");
    }

    
    public void cleanAll(){
        personRepository.deleteAll();
    }
    
    public Person getPersonByName(String name){
        return personRepository.getPersonByName(name);
    }
    
    public List<Person> getPersonMateByName(String name){
        return personRepository.getPersonMateByName(name);
    }
}
