package com.sauzny.sb_neo4j_demo.w3cschool.node;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.sauzny.sb_neo4j_demo.marve01.domain.Person;

import lombok.Data;

@NodeEntity
@Data
public class GoogleProfile {

   @Id 
   @GeneratedValue
   private Long id;            
   private String name;
   private String address;
   private String sex;
   private String dob;
   
   //关系直接定义在节点中
   @Relationship(type = "IS_FRIEND_OF", direction=Relationship.OUTGOING)
   private List<GoogleProfile> friends;
}