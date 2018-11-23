package com.sauzny.springbootweb.controller.vo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/19 - 16:33
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Getter
@Setter
@ApiModel(description = "用户信息")
public class UserInfo {

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "头像地址")
    private String avatar = "https://dummyimage.com/80/A9F5F2/000000";

    @ApiModelProperty(value = "用户角色名字集合")
    private Set<String> roles = Sets.newHashSet();
}
