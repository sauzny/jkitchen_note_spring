package com.sauzny.springboot.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @PersistenceContext
    private EntityManager em;
    
    // 增加此注解，即可
    @Transactional
    // 设置 隔离级别 传播行为
    // @Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
    public void testTransactional(){
        
        // 创建10条记录
        userRepository.save(new User("AAA", "testAAAmail@gmail.com"));
        userRepository.save(new User("BBB", "testBBBmail@gmail.com"));
        userRepository.save(new User("CCC", "testCCCmail@gmail.com"));
        userRepository.save(new User("DDD", "testDDDmail@gmail.com"));
        userRepository.save(new User("EEE", "testEEEmail@gmail.com"));
        userRepository.save(new User("FFF", "testFFFmail@gmail.com"));
        userRepository.save(new User("GGG", "testGGGmail@gmail.com"));
        userRepository.save(new User("HHH", "testHHHmail@gmail.com"));
        userRepository.save(new User("III", "testIIImail@gmail.com"));
        userRepository.save(new User("JJJ", "testJJJmail@gmail.com"));
        
        userRepository.save(new User("JJJJJJJJJJJJJJJ", "testJJJmail@gmail.com"));
    }
    
    @Transactional
    public void batchInsert(){
        
        List<User> list = Lists.newArrayList();
        list.add(new User("AAA", "testAAAmail@gmail.com"));
        list.add(new User("BBB", "testBBBmail@gmail.com"));
        list.add(new User("CCC", "testCCCmail@gmail.com"));
        list.add(new User("DDD", "testDDDmail@gmail.com"));
        list.add(new User("EEE", "testEEEmail@gmail.com"));
        list.add(new User("FFF", "testFFFmail@gmail.com"));
        list.add(new User("GGG", "testGGGmail@gmail.com"));
        list.add(new User("HHH", "testHHHmail@gmail.com"));
        list.add(new User("III", "testIIImail@gmail.com"));
        list.add(new User("JJJ", "testJJJmail@gmail.com"));
        
        for(int i = 0; i < list.size(); i++) {  
            em.persist(list.get(i));  
            if(i % 5 == 0) {  
                em.flush();  
                em.clear();  
            }  
        }
    }

    @Transactional
    public void batchUpdate(){
        
        List<User> list = Lists.newArrayList();
        list.add(new User(54L, "AAA", "testAAAmail@google.com"));
        list.add(new User(55L, "BBB", "testBBBmail@google.com"));
        //list.add(new User(56L, "CCC", "testCCCmail@google.com"));
        list.add(new User(57L, "DDD", "testDDDmail@google.com"));
        list.add(new User(58L, "EEE", "testEEEmail@google.com"));
        //list.add(new User(59L, "FFF", "testFFFmail@google.com"));
        list.add(new User(60L, "GGG", "testGGGmail@google.com"));
        //list.add(new User(61L, "HHH", "testHHHmail@google.com"));
        list.add(new User(62L, "III", "testIIImail@google.com"));
        list.add(new User(63L, "JJJ", "testJJJmail@google.com"));
        
        for(int i = 0; i < list.size(); i++) {  
            em.merge(list.get(i));  
            if(i % 5 == 0) {  
                em.flush();  
                em.clear();  
            }  
        }
    }
    
    public void save() {


        // 保存单个对象并返回。
        User savedUser = userRepository.save(new User("TestBob", "testmail@gmail.com")); 
        
        // 保存多个对象并返回。
        List<User> userList = Lists.newArrayList();
        User newUser;
        for (int i = 0; i < 10; i++) {
            newUser = new User("TestBob" + i, "testmail"+i+"@gmail.com");
            userList.add(newUser);
        }
        List<User> savedUserList = userRepository.saveAll(userList);
    }
    
    public void find(){
        
        // 根据主键查询单个对象。
        User foundUser = userRepository.findById(1L).get();
        
        // 查询全部对象。
        List<User> foundUserList = userRepository.findAll();
        
        // 根据 id 字段查询并排序，默认是顺序（ASC）。
        List<User> foundASCSortedUserList = userRepository.findAll(Sort.by("id"));
        
        // 根据 id 字段倒序查询（DESC）。
        List<User> foundDESCSortedUserList = userRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        
        
        User user = new User("TestBob", "test@gmail.com");
        // 1.使用 Example。
        // 创建 Example。
        Example<User> userExample = Example.of(user);
        User foundExampleUser = userRepository.findOne(userExample).get();
        // 2.使用 ExampleMatcher。
        // 创建 ExampleMatcher。
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                // 忽略 id 和 createTime 字段。
                .withIgnorePaths("id", "createTime")
                // 忽略大小写。
                .withIgnoreCase()
                // 忽略为空字段。
                .withIgnoreNullValues();
        // 携带 ExampleMatcher。
        userExample = Example.of(user, exampleMatcher);
        User foundExampleWithExampleMatcherUser = userRepository.findOne(userExample).get();
    }
    
    public Page<User> page(){
        
        // 分页查询，从 0 页开始查询 5 个。
        Page<User> foundUserPage = userRepository.findAll(PageRequest.of(0, 3));
        // 分页表。
        List<User> content = foundUserPage.getContent();
        // 总数量。
        long totalElements = foundUserPage.getTotalElements();
        // 总页数。
        long totalPages = foundUserPage.getTotalPages();
        // 分页表大小。
        int size = foundUserPage.getSize();
        // 
        int number = foundUserPage.getNumber();
        
        log.info("{},{},{},{}",totalElements,totalPages,size,number);
        
        return foundUserPage;
    }
    
    public void del(){
        
        // 根据主键删除单个对象
        userRepository.deleteById(1L);
        
        // 根据对象删除单个对象
        User user = new User("TestBob", "testmail@gmail.com"); 
        userRepository.delete(user);
        
        // 删除全部
        userRepository.deleteAll();
        
        // 删除多个对象
        List<User> userList = Lists.newArrayList();
        User userTemp = null;
        for (int i = 0; i < 10; i++) {
            userTemp = new User("TestBob" + i, "testmail"+i+"@gmail.com");
            userList.add(userTemp);
        }
        userRepository.deleteAll(userList);
    }
    
    public void other(){
        
        // 统计对象数量
        long count = userRepository.count();
        
        // 判断对象是否存在
        boolean exists = userRepository.existsById(1L);
    }
    
}
