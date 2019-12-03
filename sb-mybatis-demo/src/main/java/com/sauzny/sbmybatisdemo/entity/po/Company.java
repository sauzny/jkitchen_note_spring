package com.sauzny.sbmybatisdemo.entity.po;

import java.util.Date;
import javax.annotation.Generated;

public class Company {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer companyId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String companyName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String companyEmail;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date modifyTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCompanyId() {
        return companyId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCompanyName() {
        return companyName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCompanyEmail() {
        return companyEmail;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getModifyTime() {
        return modifyTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyEmail=").append(companyEmail);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}