package com.ctco.springEx;

import java.util.List;

/**
 * Created by asus-cp on 2017-08-03.
 *
 * 测试依赖注入的实体
 */
public class DIBean {

    private Integer id;

    private String name;

    private Dog dog;

    private List<String> strs;

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
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    @Override
    public String toString() {
        return "DIBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                ", strs=" + strs +
                '}';
    }
}
