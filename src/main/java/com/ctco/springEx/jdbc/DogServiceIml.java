package com.ctco.springEx.jdbc;

/**
 * Created by asus-cp on 2017-08-07.
 */
public class DogServiceIml implements DogService {

    private DogDao dogDao;

    public DogDao getDogDao() {
        return dogDao;
    }

    public void setDogDao(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    /**
     * 一般都是在service里面开启事务,我会在配置文件里面进行配置事务
     */
    public void save() {
        Dog dog = new Dog(2L, "小方");
        Dog dog1 = new Dog(3L, "小黑");
        dogDao.save(dog);
        int a = 1/0;
        dogDao.save(dog1);
    }
}
