package com.ctco.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by asus-cp on 2017-07-28.
 */
public class HelloworldAction extends ActionSupport {

    @Override
    public String execute() throws Exception {

        System.out.println("HelloworldAction的execute（）方法执行了");

        return super.execute();
    }

    public String add(){
        System.out.println("HelloworldAction的add（）方法执行了");
        return "add888";
    }

    public String delete(){
        System.out.println("HelloworldAction的delete（）方法执行了");
        return "delete888";
    }
}
