package com.ctco.intercept;

import com.ctco.utils.Log;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义的拦截器，主要拦截Loginaction
 * Created by asus-cp on 2017-07-31.
 */
public class MyIntercepter implements Interceptor {

    public void init() {
        Log.log("MyIntercepter.........init");
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Log.log("MyIntercepter.........intercept");
        String actionName = actionInvocation.getProxy().getActionName();
        String nameSpace = actionInvocation.getProxy().getNamespace();
        String method = actionInvocation.getProxy().getMethod();
        String resultCode = actionInvocation.getResultCode();
        Log.log("actionName = " + actionName);
        Log.log("nameSpace" + nameSpace);
        Log.log("method = " + method);
        Log.log("resultCode = " + resultCode);

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("intercpt", "hello i am your interceptor");

        actionInvocation.invoke();

        HttpServletRequest request1 = ServletActionContext.getRequest();
        String responseMsg = (String) request1.getAttribute("intercpt");
        Log.log("又回到了拦截器:" + responseMsg);

        return null;
    }

    public void destroy() {
        Log.log("MyIntercepter.........destroy");
    }
}
