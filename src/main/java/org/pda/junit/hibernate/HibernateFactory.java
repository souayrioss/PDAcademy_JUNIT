package org.pda.junit.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateFactory {
  public static EntityManager getEntityManager(){
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    return entityManagerFactory.createEntityManager();
  }
}
