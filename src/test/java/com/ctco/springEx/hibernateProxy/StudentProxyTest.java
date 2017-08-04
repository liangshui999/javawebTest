package com.ctco.springEx.hibernateProxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class StudentProxyTest {

    @Test
    public void test(){

        TransactionA transactionA = new TransactionA();
        StudentDaoIml studentDaoIml = new StudentDaoIml();
        StudentInteceptor studentInteceptor = new StudentInteceptor(transactionA, studentDaoIml);


        //使用jdk提供的方法生成代理类（由程序员提供被代理类）
        //第一个参数是被代理类的类加载器，第二个参数是被代理类的所有接口
        StudentDao studentDaoImlProxy = (StudentDao) Proxy.newProxyInstance(studentDaoIml.getClass().getClassLoader(),
                studentDaoIml.getClass().getInterfaces(), studentInteceptor);
        studentDaoImlProxy.addStudent();
        studentDaoImlProxy.deleteStudent();
        studentDaoImlProxy.updateStudent();
        studentDaoImlProxy.getAllStudent();
    }

}