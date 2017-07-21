package com.ctco.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by asus-cp on 2017-07-20.
 */
public class Classes implements Serializable{

    private Long id;

    private String name;

    private Set<Student> students;

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
