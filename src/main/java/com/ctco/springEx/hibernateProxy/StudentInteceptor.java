package com.ctco.springEx.hibernateProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class StudentInteceptor implements InvocationHandler {

    private TransactionA transactionA;

    private StudentDaoIml studentDaoIml;

    public StudentInteceptor(TransactionA transactionA, StudentDaoIml studentDaoIml){
        this.transactionA = transactionA;
        this.studentDaoIml = studentDaoIml;
    }

    /**
     * @param proxy 代理对象，不是被代理的对象，千万不要弄错了
     * @param method 被代理的方法
     * @param args 被代理的方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object obj;
        if("addStudent".equals(methodName) || "deleteStudent".equals(methodName)
                || "updateStudent".equals(methodName)){
            transactionA.beginTransaction();
            //参数是被代理的对象，千万不要写成了proxy
            obj = method.invoke(studentDaoIml);
            transactionA.commitTransaction();
        }else{
            obj = method.invoke(studentDaoIml);
        }
        return obj;
    }

    /**
     *  切面：TransactionA这个类就是切面
     *  通知：切面里面的方法就是通知
     *  切入点：if("addStudent".equals(methodName) || "deleteStudent".equals(methodName)
                || "updateStudent".equals(methodName))，这个条件就是切入点
     *
     */

}
