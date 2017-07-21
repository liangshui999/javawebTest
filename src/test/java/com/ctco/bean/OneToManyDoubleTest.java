package com.ctco.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 4、保存班级的时候同时保存学生，并且建立班级和学生之间的关系
 * 5、已经存在一个班级，新建一个学生，并且建立该学生和该班级之间的关系
 * 6、已经存在一个学生，新建一个班级，并且建立该学生和该班级之间的关系
 * 7、已经存在一个学生，已经存在一个班级，解除该学生和原来班级之间的关系，建立该学生和新班级之间的关系
 * 8、已经存在一个学生，解除该学生和该学生所在班级之间的关系
 * 9、解除该班级和所有的学生之间的关系，再重新建立该班级和一些新的学员之间的关系
 * 10、解除该班级和所有的学生之间的关系
 * 11、删除班级
 */
public class OneToManyDoubleTest {

    private static SessionFactory factory;

    static{
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }


    /**
     * 4、保存班级的时候同时保存学生，并且建立班级和学生之间的关系
     */
    @Test
    public void test4(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //新建班级
        Classes classes = new Classes();
        classes.setName("一班");

        //新建学生
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);

        //建立关系
        student.setClasses(classes);

        session.save(student);

        transaction.commit();
        session.close();
    }


    /**
     * 5、已经存在一个班级，新建一个学生，并且建立该学生和该班级之间的关系
     */
    @Test
    public void test5(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //查找一班
        Classes classes = (Classes) session.createQuery("from Classes as cls where cls.name = :name")
                .setParameter("name", "一班")
                .uniqueResult();

        //新建一个学生
        Student student = new Student();
        student.setName("李四");
        student.setAge(24);
        student.setClasses(classes);//建立关系

        session.save(student);

        transaction.commit();
        session.close();
    }


    /**
     * 6、已经存在一个学生，新建一个班级，并且建立该学生和该班级之间的关系
     */
    @Test
    public void test6(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //查找张三
        Student student = (Student) session.createQuery("from Student as stu where stu.name = :name")
                .setParameter("name", "张三")
                .uniqueResult();

        //创建班级
        Classes classes = new Classes();
        classes.setName("二班");

        //建立关系
        student.setClasses(classes);

        transaction.commit();
        session.close();
    }


    /**
     * 7、已经存在一个学生，已经存在一个班级，解除该学生和原来班级之间的关系，建立该学生和新班级之间的关系
     */
    @Test
    public void test7(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //查找张三
        Student student = (Student) session.createQuery("from Student as stu where stu.name = :name")
                .setParameter("name", "张三")
                .uniqueResult();

        //查找班级一
        Classes classes = (Classes) session.createQuery("from Classes as cls where cls.name = :name")
                .setParameter("name", "一班")
                .uniqueResult();

        //张三现在属于2班，执行完成之后建立张三让张三属于1班
        student.setClasses(classes);

        transaction.commit();
        session.close();
    }


    /**
     * 9、解除该班级和所有的学生之间的关系，再重新建立该班级和一些新的学员之间的关系
     */
    @Test
    public void test9(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //查找一班
        Classes classes = (Classes) session.createQuery("from Classes as cls where cls.name = :name")
                .setParameter("name", "一班")
                .uniqueResult();

        Set<Student> studentsQ = classes.getStudents();
        if(studentsQ == null){
            return;
        }
        for(Student stu : studentsQ){
            stu.setClasses(null);//取消关系
        }

        Student student1 = new Student();
        student1.setName("王五");
        student1.setAge(23);
        student1.setClasses(classes);

        Student student2 = new Student();
        student2.setName("赵六");
        student2.setAge(27);
        student2.setClasses(classes);

        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();
    }


}
