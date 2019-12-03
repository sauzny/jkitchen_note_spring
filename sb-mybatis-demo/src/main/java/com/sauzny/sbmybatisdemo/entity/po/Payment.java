package com.sauzny.sbmybatisdemo.entity.po;

import java.util.Date;
import javax.annotation.Generated;

public class Payment {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer paymentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String paymentName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Double paymentAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date modifyTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPaymentId() {
        return paymentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPaymentName() {
        return paymentName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Double getPaymentAmount() {
        return paymentAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
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
    public Integer getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paymentId=").append(paymentId);
        sb.append(", paymentName=").append(paymentName);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}