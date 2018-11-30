package com.sauzny.springbootweb.utils.demo;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.utils.CodecUtils;
import com.sauzny.springbootweb.utils.JacksonUtils;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/30 - 15:24
 *
 * @描述: TODO
 *
 ***************************************************************************/
public final class DataFacker {

    private DataFacker(){}

    public static Faker faker = new Faker(new Locale("zh-CN"));

    public static User user(int id){

        String username = faker.lorem().characters(6);
        String salt = faker.lorem().characters(6);
        String password = CodecUtils.sha512(CodecUtils.sha512(username)+salt);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setNickname(faker.name().username());
        user.setStatus(20);
        user.setPassword(password);
        user.setSalt(salt);
        user.setPhone(faker.phoneNumber().cellPhone());
        return user;
    }

    public static Role role(int userId){

        Map<Integer, String> map = Maps.newHashMap();
        map.put(1, "seller");
        map.put(2, "buyer");
        map.put(3, "editor");

        Role role = new Role();
        role.setUserId(userId);
        role.setName(map.get(faker.number().numberBetween(1, 4)));
        return role;
    }
    public static List<Role> roleList(int userId){
        List<Role> roleList = Lists.newArrayList();
        for(int i=0; i<faker.number().numberBetween(1, 5); i++){
            roleList.add(role(userId));
        }
        return roleList;
    }

    public static void main(String[] args) {
        for(int i=0; i<30; i++){
            System.out.println(JacksonUtils.nonNull().toJson(DataFacker.user(2)));
            System.out.println(JacksonUtils.nonNull().toJson(DataFacker.roleList(2)));
        }
    }
}
