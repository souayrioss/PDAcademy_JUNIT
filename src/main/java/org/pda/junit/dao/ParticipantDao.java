package org.pda.junit.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.Participant;
import org.pda.junit.hibernate.HibernateFactory;

import java.util.List;

public class ParticipantDao implements Idao<Participant> {

  Transaction transaction = null;
  private EntityManager em = HibernateFactory.getEntityManager();
  private Session session = em.unwrap(Session.class);

  @Override
  public Participant find(long id) {
    em.getTransaction().begin();
    Participant participant = em.find(Participant.class, id);
    em.getTransaction().commit();
    return participant;
  }

  @Override
  public List<Participant> getAll() {
    List participants = null;
    try  {
      transaction = session.beginTransaction();
      Query query = session.createQuery("from Participant ");
      participants = query.getResultList();
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return participants;
  }

  @Override
  public Participant add(Participant participant) {
    transaction = (Transaction) em.getTransaction();
    transaction.begin();
    em.persist(participant);
    transaction.commit();
    return participant;
  }

  @Override
  public void update(Participant participant) {
    transaction = (Transaction) em.getTransaction();
    transaction.begin();
    em.merge(participant);
    transaction.commit();
  }

  @Override
  public boolean delete(long id) {
    em.getTransaction().begin();
    Participant participant = em.find(Participant.class, id);
    em.getTransaction().commit();
    if (participant != null) {
      session.beginTransaction();
      session.delete(participant);
      System.out.println("participant is deleted");
      session.getTransaction().commit();
      return true;
    }
    return false;
  }
}
