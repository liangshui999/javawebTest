package com.ctco.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 1、保存班级
 * 2、保存学生
 * 3、保存班级的时候同时保存学生
 * 4、保存班级的时候同时保存学生，并且建立班级和学生之间的关系
 * 5、已经存在一个班级，新建一个学生，并且建立该学生和该班级之间的关系
 * 6、已经存在一个学生，新建一个班级，并且建立该学生和该班级之间的关系
 * 7、已经存在一个学生，已经存在一个班级，解除该学生和原来班级之间的关系，建立该学生和新班级之间的关系
 * 8、已经存在一个学生，解除该学生和该学生所在班级之间的关系
 * 9、解除该班级和所有的学生之间的关系，再重新建立该班级和一些新的学员之间的关系
 * 10、解除该班级和所有的学生之间的关系
 * 11、删除班级
 *      *
 *      	*  解除该班级和所有的学生之间的关系
 *      	*  删除该班级
 *      *
 *          删除班级的同时删除学生
 * 12、删除学生
 *      同删除班级
 * @author Administrator
 *
 */

public class OneToManyTest {

    private static SessionFactory factory;

    static{
        Configuration configuration = new Configuration();
        configuration.configure();
        factory = configuration.buildSessionFactory();
    }

    @Test
    public void saveClasses(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //初始化学生
        Set<Student> students = new HashSet<Student>();
        Student student1 = new Student("张三",19);
        Student student2 = new Student("李四", 28);
        students.add(student1);
        students.add(student2);

        //初始化班级
        Classes classes = new Classes();
        classes.setName("三1班");
        classes.setStudents(students);

        //保存班级
        session.saveOrUpdate(classes);

        transaction.commit();
        session.close();
    }

    @Test
    public void saveStudent(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student("王武", 25);
        //保存学生
        session.saveOrUpdate(student);

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

        //查找三一班
        Classes classes = session.get(Classes.class, 1L);

        //新建一个学生
        Student student = new Student("赵六", 27);

        //建立学生和班级之间的关系
        classes.getStudents().add(student);

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

        //查找李四
        Student student = session.get(Student.class, 2L);

        //新建一个班级
        Classes classes = new Classes();
        classes.setName("三2班");

        Set<Student> students = new HashSet<Student>();
        students.add(student);

        //建立新班级和学生之间的关系
        classes.setStudents(students);

        //保存新班级
        session.saveOrUpdate(classes);

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

        //查找学生王武
        Student student = (Student) session.createQuery("from Student as stu where stu.name = :name")
                .setParameter("name", "王武")
                .uniqueResult();

        //查找三2班
        Classes classes = (Classes) session.createQuery("from Classes as cls where cls.name = :name")
                .setParameter("name", "三2班")
                .uniqueResult();

        classes.getStudents().add(student);

        transaction.commit();
        session.close();
    }



}
