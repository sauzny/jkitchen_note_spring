package com.sauzny.sb_neo4j_demo.w3cschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.sb_neo4j_demo.w3cschool.node.GoogleProfile;
import com.sauzny.sb_neo4j_demo.w3cschool.repository.GoogleProfileRepository;

import lombok.extern.slf4j.Slf4j;

@Service("googleProfileService")
@Slf4j
public class GoogleProfileService {

   @Autowired
   private GoogleProfileRepository googleProfileRepository; 

   public GoogleProfile create(GoogleProfile profile) {
      log.info("save profile : {}", profile);
      return googleProfileRepository.save(profile);
   }

   public void delete(GoogleProfile profile) {      
      googleProfileRepository.delete(profile);
   }

   public GoogleProfile findById(long id) {    
      return googleProfileRepository.findById(id).orElse(null);
   }

   public Iterable<GoogleProfile> findAll() {     
      return googleProfileRepository.findAll();
   }
}
