package com.ctco.actions;

import com.ctco.bean.Address;
import com.ctco.utils.Log;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by asus-cp on 2017-08-01.
 */
public class OgnlAction extends ActionSupport{

    @Override
    public String execute() throws Exception {
        Log.log("OgnlAction...............execute");

        //获取ValueStack
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        //获取requets， session，application
        HttpServletRequest request = ServletActionContext.getRequest();
        Map<String, Object> session = ServletActionContext.getContext().getSession();
        ServletContext servletContext = ServletActionContext.getServletContext();

        //给几个作用域设置值
        String key = "name";
        request.setAttribute(key, "zhangsan_request");
        session.put(key, "zhangsan_session");
        servletContext.setAttribute(key, "zhangsan_application");

        //直接在对象栈里面设置值
        valueStack.set("sex", "男");

        Address address = new Address();
        address.setProvince("重庆市");
        address.setCity("沙坪坝区");
        valueStack.push(address);

        List<String> list = new ArrayList<String>();
        list.add("金");
        list.add("木");
        list.add("水");
        list.add("火");
        list.add("土");
        valueStack.set("list", list);

        return super.execute();
    }
}
