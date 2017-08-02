package com.ctco.actions;

import com.ctco.bean.Address;
import com.ctco.utils.Log;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by asus-cp on 2017-07-31.
 */
public class LoginAction extends ActionSupport {

    /**
     * 1，字段必须与表单里面的name属性相同
     * 2，必须为这些字段设置get和set方法，否则是获取不到值的
     */
    private String userName;

    private String password;

    private Date date;

    /**
     * 这种必须在界面的表单里面采用 address.province和address,city这种方式
     */
    private Address address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("LoginAction............execute");
        log("userName = " + userName);
        log("password = " + password);
        log("date = " + date);
        log("address = " + address);

        HttpServletRequest request = ServletActionContext.getRequest();
        String msg = (String) request.getAttribute("intercpt");
        Log.log("收到的信息msg = " + msg);
        request.setAttribute("intercpt", "信息已经收到,拦截器你好");
        return SUCCESS;
    }

    private void log(String msg){
        System.out.println(msg);
    }
}
