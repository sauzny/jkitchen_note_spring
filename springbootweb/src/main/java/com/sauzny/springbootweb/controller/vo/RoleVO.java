package com.sauzny.springbootweb.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/28 - 16:29
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Getter
@Setter
@ApiModel(description = "角色信息")
public class RoleVO {

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "状态")
    private int status;

    @ApiModelProperty(value = "创建时间")
    private long cstCreate;

    @ApiModelProperty(value = "最后修改时间")
    private long cstModified;
}
