package com.sauzny.springboot.jpa;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//<User, Long> 泛型指定了能接受的对象类型和其主键类型，主键类型在一些方法里很有用。
public interface UserRepository extends JpaRepository<User, Long> {

    // JpaRepository 的API 分为三类
    /*
         1.默认实现，基本的 CRUD
         2.接口规范方法名查询
         3.手动编写hql或sql操作
     */
    
    // 1.默认实现的CRUD在UserService类中有demo
    
    // 2.JpaRepository支持接口规范方法名查询。
    /*
                        意思是如果在接口中定义的查询方法符合它的命名规则，就可以不用写实现，目前支持的关键字如下。

                        可查看 md/JpaRepository.md 中的描述
     */
    
    // 3.手动编写hql或sql操作
    
    // @Query的1代表的是方法参数里面的顺序,hql
    @Query("select t from User t where t.username = ?1")
    User findByUserName1(String username);

    // 本地原生sql，注意表名，因为是原生sql
    @Query(value = "select * from user t where t.task_name = ?1", nativeQuery = true)
    User findByUserName2(String username);

    // @Param注解绑定参数
    @Query("select t from User t where t.username = :username and t.createTime = :createTime")
    User findByUserName3(@Param("username") String username, @Param("createTime") Date createTime);

    // 问号绑定参数
    @Query("select t from User t where t.username = ? and t.createTime = ?")
    User findByUserName4(String username, Date createTime);

    // SPEL表达式，泛型DAO的时候可能会用到
    /**
        　　实体类User,使用@Entity注解后，spring会将实体类User纳入管理。默认'#{#entityName}'的值就是'User'。
        
        　　但是如果使用了@Entity(name = "user")来注解实体类User,此时'#{#entityName}'的值就变成了'user'。
        
        　　到此，事情就明了了，只需要在用@Entity来注解实体类时指定name为此实体类对应的表名。在原生sql语句中，就可以把'#{#entityName}'来作为数据表名使用。
     */
    @Query("select t from #{#entityName} t where t.username = ? and t.createTime = ?")
    User findByUserName5(String username, Date createTime);

    // 注解中使用枚举类
    @Query("SELECT u FROM #{#entityName} u " + "WHERE u.status = #{T(fully.qualified.path.UserModel).STATUS_ACTIVE}") 
    
    //hql(sql)修改或者删除（delete xxx）
    //flushAutomatically = true 执行 modifying query 之前会先调用 flush 操作，从而避免数据丢失问题。
    //clearAutomatically = true 清理一级缓存
    /**
    自动清理之后还会带来一个新的问题，clear 操作清理的缓存中，还包括提交后未 flush 的数据，
    例如调用 save 而不是 saveAndFlush 就有可能不会立即将修改内容更新到数据库中，
    在 save 之后 flush 之前调用 @Modifying(clearAutomatically = true) 修饰的方法就有可能导致修改丢失。
     */
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update User t set t.username = ?1 where t.id = ?2")
    int updateUser(String username, Long id);
}
