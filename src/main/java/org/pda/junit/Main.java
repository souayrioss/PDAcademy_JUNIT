package org.pda.junit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.pda.junit.entity.*;
import org.pda.junit.hibernate.HibernateFactory;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    System.out.println("entityManager open "+entityManagerFactory.isOpen());
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Admin responsable = new Admin();
    responsable.setFirstName("Oussama");
    responsable.setLastName("Souayri");
    responsable.setEmail("souayrioss@gmail.com");
    responsable.setPassword("azerty");
    responsable.setUsername("zoro");
    responsable.setPhoneNumber("052442562");
    responsable.setRole(Role.ADMIN);
    Gender homme = Gender.MALE;
    responsable.setGender(homme);
    responsable.setState(State.ACTIVE);
    entityManager.persist(responsable);
    System.out.println("name "+entityManager.find(User.class,1).getFirstName());
    System.out.println("done");
    entityManager.getTransaction().commit();
    entityManager.getTransaction().begin();
    entityManager.createQuery("select user from User user", User.class).getResultList().stream().map(u->u.getFirstName()).forEach(System.out::println);
    entityManager.getTransaction().commit();
  }
}
