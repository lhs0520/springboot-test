package com.winter.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -3946734305303957850L;

    private Integer id;

    private String name;

    private Integer age;

    private String address;

    private String sex;

    private String telephonenum;

    private String profession;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTelephonenum() {
        return telephonenum;
    }

    public void setTelephonenum(String telephonenum) {
        this.telephonenum = telephonenum == null ? null : telephonenum.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address='").append(address).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", telephonenum='").append(telephonenum).append('\'');
        sb.append(", profession='").append(profession).append('\'');
        sb.append('}');
        return sb.toString();
    }
}