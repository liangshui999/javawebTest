package com.ctco.springEx.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class PersonInteceptor implements InvocationHandler {

    private PersonDaoIml personDaoIml;

    private Transaction transaction;

    public PersonInteceptor(PersonDaoIml personDaoIml, Transaction transaction) {
        this.personDaoIml = personDaoIml;
        this.transaction = transaction;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if("save".equals(methodName) || "delete".equals(methodName) || "update".equals(methodName)){
            transaction.beginTransaction();
            method.invoke(personDaoIml, args);
            transaction.commit();
        }else{
            method.invoke(personDaoIml, args);
        }

        return null;
    }
}
