package org.pda.junit.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pda.junit.entity.Admin;
import org.pda.junit.hibernate.HibernateFactory;

import java.util.List;

public class AdminDao implements Idao<Admin>{
  Transaction transaction = null;
  private EntityManager em = HibernateFactory.getEntityManager();
  private Session session = em.unwrap(Session.class);
  @Override
  public Admin find(long id) {
    return null;
  }

  @Override
  public List<Admin> getAll() {
    return null;
  }

  @Override
  public Admin add(Admin entity) {
    transaction = (Transaction) em.getTransaction();
    transaction.begin();
    em.persist(entity);
    transaction.commit();
    return entity;
  }

  @Override
  public Admin update(Admin entity) {
  return null;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
