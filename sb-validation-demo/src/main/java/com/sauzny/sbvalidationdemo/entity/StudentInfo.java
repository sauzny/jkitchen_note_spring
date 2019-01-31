package com.sauzny.sbvalidationdemo.entity;

import com.sauzny.sbvalidationdemo.customize.Money;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/***************************************************************************
 *
 * @时间: 2019/1/31 - 13:25
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class StudentInfo {

    @NotBlank(message="用户名不能为空")
    private String userName;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄是整数")
    private String age;

    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;

    @NotBlank(message="学校不能为空")
    private String school;

    @NotNull(message="金额不能为空")
    @Money(message="金额格式不正确")
    private Double money;

    // 如果不加@NotNull，则prentInfo=null时，不会对ParentInfo内的字段进行校验
    @NotNull(message="父母信息不能为空")
    @Valid
    private ParentInfo parentInfo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public ParentInfo getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(ParentInfo parentInfo) {
        this.parentInfo = parentInfo;
    }
}
