package com.sauzny.sbvalidationdemo.entity;

import org.hibernate.validator.constraints.NotBlank;

/***************************************************************************
 *
 * @时间: 2019/1/31 - 13:33
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class ParentInfo {

    @NotBlank(message="父亲名称不能为空")
    private String fatherName;

    @NotBlank(message="母亲名称不能为空")
    private String motherName;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
