package com.ctco.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by asus-cp on 2017-07-21.
 */
public class SubClassMapTest {

    private static SessionFactory factory;

    static{
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }


    @Test
    public void testSave(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setName("张三");

        Customer customer = new Customer();
        customer.setName("李四");
        customer.setComments("这个工作人员的服务态度真差");

        Employee employee = new Employee();
        employee.setName("王武");
        employee.setCompany("中国石油");

        Employee employee2 = new Employee();
        employee2.setName("霓虹灯");
        employee2.setCompany("中国石油");

        Employee employee3 = new Employee();
        employee3.setName("彩虹灯");
        employee3.setCompany("中国石油");

        Manager manager = new Manager();
        manager.setName("赵柳");
        manager.setCompany("中国石油");

        //统一由多的一方来建立关系
        customer.setEmployee(employee);
        employee.setManager(manager);
        employee2.setManager(manager);
        employee3.setManager(manager);

        //持久化
        session.saveOrUpdate(person);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(employee2);
        session.saveOrUpdate(employee3);

        transaction.commit();
        session.close();
    }

}
