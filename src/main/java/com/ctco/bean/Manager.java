package com.ctco.bean;

import java.util.Set;

/**
 * Created by asus-cp on 2017-07-21.
 */
public class Manager extends Employee{

    private Set<Employee> employees;//手下有一堆职员


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
