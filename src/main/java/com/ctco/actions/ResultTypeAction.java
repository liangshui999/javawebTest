package com.ctco.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by asus-cp on 2017-07-28.
 */
public class ResultTypeAction extends ActionSupport {

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("name", "张三");

        return super.execute();
    }


}
