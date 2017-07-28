package com.ctco.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 主要用于测试通配符
 * Created by asus-cp on 2017-07-28.
 */
public class ProductAction extends ActionSupport {

    public String add(){
        System.out.println("ProductAction...........add");
        return SUCCESS;
    }

    public String delete(){
        System.out.println("ProductAction...........delete");
        return SUCCESS;
    }

    public String update(){
        System.out.println("ProductAction...........update");
        return SUCCESS;
    }

    public String query(){
        System.out.println("ProductAction...........query");
        return SUCCESS;
    }
}
