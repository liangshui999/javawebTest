package com.ctco.springEx.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Created by asus-cp on 2017-08-04.
 */
public class PersonTest {

    /**
     * 手工实现动态代理
     */
    @Test
    public void test(){
        Transaction transaction = new Transaction();
        PersonDaoIml personDaoIml = new PersonDaoIml();
        PersonInteceptor inteceptor = new PersonInteceptor(personDaoIml, transaction);

        //由jdk生成代理对象(被代理对象的信息有程序员提供)
        PersonDao personDaoImlProxy = (PersonDao) Proxy.newProxyInstance(PersonDaoIml.class.getClassLoader(),
                PersonDaoIml.class.getInterfaces(),inteceptor);
        personDaoImlProxy.save();
        personDaoImlProxy.delete();
        personDaoImlProxy.update();
        personDaoImlProxy.getAllPerson();
    }


    /**
     * 测试aop实现动态代理
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ctco/springEx/aop/applicationContext.xml");
        PersonDao personDaoImlProxy = (PersonDao) context.getBean("personDao");
        personDaoImlProxy.save();
        personDaoImlProxy.delete();
        personDaoImlProxy.update();
        personDaoImlProxy.getAllPerson();
    }

}