package org.pda.junit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.pda.junit.entity.Admin;

public class AdminRepository implements IAuthRepository<Admin>{
  @Override
  public Admin login(String loginKey, String Password) {
    Admin admin = new AdminRepository().findByEmail(loginKey);

    if(admin == null){
      admin = new AdminRepository().findByUsername(loginKey);
      if(admin == null ){
        return null;
      }
    }
    return  (admin.getPassword().equals(Password)) ? admin : null;
  }

  @Override
  public void logout() {

  }

  @Override
  public Admin findByEmail(String loginKey) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    entityManagerFactory.isOpen();
    try{
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.getTransaction().commit();
      return entityManager.createQuery("SELECT adm FROM Admin adm WHERE adm.email LIKE :loginKey",Admin.class).setParameter("loginKey", loginKey).getSingleResult();
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public Admin findByUsername(String loginKey) {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    entityManagerFactory.isOpen();
    try{
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.getTransaction().commit();
      return entityManager.createQuery("SELECT adm FROM Admin adm WHERE adm.username LIKE :loginKey",Admin.class).setParameter("loginKey", loginKey).getSingleResult();
    }catch(Exception e){
      return null;
    }
  }
}
