package com.ctco.bean;

/**
 * Created by asus-cp on 2017-07-23.
 *
 * 主要是用于测试二级缓存
 */
public class Dog {

    private Long id;

    private String name;

    public Dog(){}

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
