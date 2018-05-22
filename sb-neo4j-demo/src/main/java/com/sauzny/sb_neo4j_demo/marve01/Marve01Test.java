package com.sauzny.sb_neo4j_demo.marve01;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.sb_neo4j_demo.marve01.domain.Person;
import com.sauzny.sb_neo4j_demo.marve01.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Marve01Test {

    @Autowired
    private PersonService personService;
    
    @PostConstruct
    public void foo01(){
        //personService.cleanAll();
        //personService.initData();
        Person person = personService.getPersonByName("美国队长");
        List<Person> mates = personService.getPersonMateByName("美国队长");
        
        log.info("Person : {}", person);
        log.info("Person mates: {}", mates);
    }
}
