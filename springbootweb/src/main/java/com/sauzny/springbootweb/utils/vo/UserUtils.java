package com.sauzny.springbootweb.utils.vo;

import java.util.List;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.sauzny.springbootweb.controller.vo.PageContent;
import com.sauzny.springbootweb.controller.vo.UserVO;
import com.sauzny.springbootweb.entity.dto.UserDTO;
import com.sauzny.springbootweb.entity.pojo.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class UserUtils {

    private UserUtils(){}

    public static UserVO userDTO2VO(UserDTO user){
        log.debug("{} {}", user.getCstCreate(), user.getCstCreate().getTime());
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getUsername());
        userVO.setRoles(user.getRoleNames());
        userVO.setStatus(user.getStatus());
        userVO.setNickname(user.getNickname());
        userVO.setCstCreate(user.getCstCreate().getTime());
        userVO.setCstModified(user.getCstModified().getTime());
        userVO.setPhone(user.getPhone());
        return userVO;
    }
    

    public static List<UserVO> userDTO2VOList(List<UserDTO> userList){
        List<UserVO> userVOList = Lists.newArrayList();
        userList.forEach(user -> userVOList.add(userDTO2VO(user)));
        return userVOList;
    }

    public static PageContent<UserVO> userDTO2VOPage(Page<UserDTO> page){
        PageContent<UserVO> pageContent = PageContentUtils.pageContent(page);
        pageContent.setContent(userDTO2VOList(page.getResult()));
        return pageContent;
    }

    public static UserVO userVO(User user){
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getUsername());
        userVO.setStatus(user.getStatus());
        userVO.setNickname(user.getNickname());
        userVO.setCstCreate(user.getCstCreate().getTime());
        userVO.setCstModified(user.getCstModified().getTime());
        userVO.setPhone(user.getPhone());
        return userVO;
    }


    public static List<UserVO> userVOList(List<User> userList){
        List<UserVO> userVOList = Lists.newArrayList();
        userList.forEach(user -> userVOList.add(userVO(user)));
        return userVOList;
    }

    public static PageContent<UserVO> userVOPage(Page<User> page){
        PageContent<UserVO> pageContent = PageContentUtils.pageContent(page);
        pageContent.setContent(userVOList(page.getResult()));
        return pageContent;
    }



    public static UserDTO userDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setStatus(user.getStatus());
        userDTO.setNickname(user.getNickname());
        userDTO.setCstCreate(user.getCstCreate());
        userDTO.setCstModified(user.getCstModified());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }


    public static List<UserDTO> userDTOList(List<User> userList){
        List<UserDTO> userDTOList = Lists.newArrayList();
        userList.forEach(user -> userDTOList.add(userDTO(user)));
        return userDTOList;
    }

    public static PageContent<UserDTO> userDTOPage(Page<User> page){
        PageContent<UserDTO> pageContent = PageContentUtils.pageContent(page);
        pageContent.setContent(userDTOList(page.getResult()));
        return pageContent;
    }

    public static User user(UserVO userVO){

        User user = new User();

        user.setId(userVO.getId());
        user.setUsername(userVO.getUsername());
        user.setStatus(userVO.getStatus());
        user.setNickname(userVO.getNickname());
        user.setPhone(userVO.getPhone());

        return user;
    }
}
