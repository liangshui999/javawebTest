package com.ctco.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by asus-cp on 2017-07-24.
 *
 * 主要是用于测试一级缓存和二级缓存相关的问题
 */
public class StudentTest {

    private static SessionFactory factory;

    @BeforeClass
    public static void init(){
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }

    /**
     * 测试list（）方法
     */
    @Test
    public void testList(){
        Session session = factory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        System.out.println("students = " + students);
        students = session.createQuery("from Student").list();
        System.out.println("students = " + students);
        session.close();
    }


    /**
     * 测试iterator（）方法
     * iterate()会造成n + 1的问题
     */
    @Test
    public void testIterate(){
        Session session = factory.openSession();
        Iterator<Student> iterator = session.createQuery("from Student").iterate();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        session.close();
    }


    /**
     * list和iterate联合使用
     */
    @Test
    public void testListAndIterate(){
        Session session = factory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        //System.out.println("students = " + students);

        Iterator<Student> iterator = session.createQuery("from Student").iterate();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        session.close();
    }


    /**
     * 测试二级缓存是否会缓存hql语句，答案是不会
     * 二级缓存会缓存save update get但是不会缓存hql查询的结果
     *
     * 要想有效的话，必须开启查询缓存,且2次查询的参数和hql语句都要相同
     * <property name="hibernate.cache.use_query_cache">true</property>
     * .setCacheable(true)
     * 查询缓存缓存的是id，此时由于在缓存中已经存在了这样的一组学生数据，但是仅仅只是缓存了
     * id，所以此处会发出大量的sql语句根据id取对象，这也是发现N+1问题的第二个原因
     * 所以如果使用查询缓存必须开启二级缓存
     */
    @Test
    public void testTwoLevelCachAndHql(){

        Session session = factory.openSession();
        List<Student> students = session.createQuery("from Student ").setCacheable(true).list();
        System.out.println("students = " + students);
        session.close();

        session = factory.openSession();
        students = session.createQuery("from Student ").setCacheable(true).list();
        System.out.println("students = " + students);
        session.close();

    }


}
