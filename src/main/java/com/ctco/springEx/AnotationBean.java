package com.ctco.springEx;

import javax.annotation.Resource;

/**
 * Created by asus-cp on 2017-08-03.
 */
public class AnotationBean {

    /**
     * 注解只能用于引用类型
     * 基本类型还是需要手工在配置文件中注入
     * 基本类型必须有set方法
     */
    private Long id;
    private String name;


    /**
     * Resource注解会自动帮助注入
     * Resource注解不需要有set方法
     */
    @Resource
    private Dog dog;

    public Dog getDog() {
        return dog;
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

    @Override
    public String toString() {
        return "AnotationBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
