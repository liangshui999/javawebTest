package com.ctco.bean;

import java.io.Serializable;

/**
 * Created by asus-cp on 2017-07-20.
 */
public class Student implements Serializable{

    private Long id;

    private String name;

    private int age;

    private Classes classes;

    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
