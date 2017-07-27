package com.ctco.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by asus-cp on 2017-07-23.
 * 主要测试二级缓存
 */
public class DogTest {

    private static SessionFactory factory;

    static{
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }


    /**
     * 看能否存入二级缓存 save()方法会存入二级缓存
     */
    @Test
    public void testSave(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Dog dog = new Dog("大黄");
        session.save(dog);//肯定是存入一级缓存了,至于是否存入了二级缓存就不知道了？
        transaction.commit();
        session.close();

        //二级缓存和一级缓存都清掉
        session = factory.openSession();
        transaction = session.beginTransaction();
        //dog = session.get(Dog.class, 1L);
        //session.clear();//只能清理一级缓存
        //factory.getCache().evictAll();//二级缓存统一在getCache（）里面管理
        transaction.commit();
        session.close();

        session = factory.openSession();
        transaction = session.beginTransaction();
        Dog dog1 = session.get(Dog.class, 1L);
        System.out.println(dog1);
        transaction.commit();
        session.close();
    }


    /**
     * 测试update是否会存入二级缓存,当usage设置成read-write时才会存入二级缓存，当设置成read-only时
     * 会抛出异常Can't write to a readonly object
     * <!--注意cache选项的位置-->
     *  <cache usage="read-write"/>
     */
    @Test
    public void testUpdate(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Dog dog = session.get(Dog.class, 1L);
        dog.setName("大黄");
        transaction.commit();
        session.close();

        //清除二级缓存
        factory.getCache().evictAll();

        session = factory.openSession();
        dog = session.get(Dog.class, 1L);
        System.out.println(dog);
    }

}
