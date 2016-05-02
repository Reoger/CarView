package com.create.testserializable;

import java.io.Serializable;

/**
 * Created by 24540 on 2016/5/2.
 */
public class Person implements Serializable{
    private String name;
    private int age;
    private String sex;
    private int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
