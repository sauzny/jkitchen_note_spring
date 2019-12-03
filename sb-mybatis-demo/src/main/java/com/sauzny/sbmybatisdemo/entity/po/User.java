package com.sauzny.sbmybatisdemo.entity.po;

import java.util.Date;
import javax.annotation.Generated;

public class User {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userSex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer userAge;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userIdNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userPhoneNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userEmail;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date modifyTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer companyId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserName() {
        return userName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserSex() {
        return userSex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUserAge() {
        return userAge;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserIdNo() {
        return userIdNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserIdNo(String userIdNo) {
        this.userIdNo = userIdNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserEmail() {
        return userEmail;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserState() {
        return userState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCompanyId() {
        return companyId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userSex=").append(userSex);
        sb.append(", userAge=").append(userAge);
        sb.append(", userIdNo=").append(userIdNo);
        sb.append(", userPhoneNum=").append(userPhoneNum);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", userState=").append(userState);
        sb.append(", companyId=").append(companyId);
        sb.append("]");
        return sb.toString();
    }
}