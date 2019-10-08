package com.sauzny.springbootweb.controller.vo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sauzny.springbootweb.SbwConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
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
public class UserVO {

    @ApiModelProperty(value = "唯一标识")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "头像地址")
    private String avatar = "https://dummyimage.com/80/A9F5F2/000000";

    @ApiModelProperty(value = "用户角色数组")
    private Set<String> roles = Sets.newHashSet();

    @ApiModelProperty(value = "状态")
    private int status;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "创建时间")
    private long cstCreate;

    @ApiModelProperty(value = "最后修改时间")
    private long cstModified;

    @ApiModelProperty(value = "用户角色")
    private Map<String, Object> roleEnum;

    @ApiModelProperty(value = "用户角色enum")
    private Set<SbwConstant.UserRoleEnum> roleEnums = Sets.newHashSet();

}
