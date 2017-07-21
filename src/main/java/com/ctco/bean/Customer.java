package com.ctco.bean;

/**
 * Created by asus-cp on 2017-07-21.
 */
public class Customer extends Person {

    /**
     * 评论
     */
    private String comments;

    private Employee employee;//有一个职员为哥们专门服务


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
