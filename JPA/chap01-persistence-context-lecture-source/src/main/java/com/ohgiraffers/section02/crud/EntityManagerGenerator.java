package com.ohgiraffers.section02.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {
    private static EntityManagerFactory entityManagerGenerator = Persistence.createEntityManagerFactory("ohgiraffers");
    private EntityManagerGenerator(){}
    public static EntityManager getManagerInstance() {
        return entityManagerGenerator.createEntityManager();
    }
}
