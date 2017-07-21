package com.ctco.bean;

import java.util.Set;

/**
 * Created by asus-cp on 2017-07-21.
 */
public class Employee extends Person{

    protected String company;//所属的公司

    private Set<Customer> customers;//为一堆顾客服务

    private Manager manager;//只有一个领导

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

