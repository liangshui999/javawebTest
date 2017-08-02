package com.ctco.modledriven;

import com.ctco.bean.User;
import com.ctco.utils.Log;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by asus-cp on 2017-08-01.
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

    private User user = new User();//这儿必须new

    /**
     * 模型驱动的拦截器会调用这个方法，将user压入对象栈的栈顶
     */
    public User getModel() {
        return user;
    }

    public String save(){
        Log.log("UserAction.........save()");
        Log.log("user = " + user);
        return "save";
    }

    /**
     *
     * 主要用于页面回显
     */
    public String edit(){
        Log.log("UserAction.........edit()");
        user.setName("孙武回显");
        user.setPassword("66666");
        return "edit";
    }


    public String update(){
        Log.log("UserAction.........update()");
        Log.log("user = " + user);
        return "update";
    }


}
