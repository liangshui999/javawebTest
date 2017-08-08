package com.ctco.springEx.hibernate;

/**
 * Created by asus-cp on 2017-08-07.
 */
public class AnimalServiceIml implements AnimalService {

    private AnimalDao animalDao;

    public AnimalDao getAnimalDao() {
        return animalDao;
    }

    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public void save(Animal animal) {
        animalDao.save(animal);
    }
}
