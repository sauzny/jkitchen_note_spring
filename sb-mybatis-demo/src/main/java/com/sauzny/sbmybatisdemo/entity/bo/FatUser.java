package com.sauzny.sbmybatisdemo.entity.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FatUser {

    private Integer userId;

    private String userName;

    private Integer companyId;

    private String companyName;
}
