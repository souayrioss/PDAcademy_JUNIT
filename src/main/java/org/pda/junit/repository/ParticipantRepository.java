package org.pda.junit.repository;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.pda.junit.entity.Participant;
import org.pda.junit.hibernate.HibernateFactory;

public class ParticipantRepository implements IAuthRepository<Participant>,IFilterRepository<Participant>{
  private EntityManager em = HibernateFactory.getEntityManager();
  private Session session = em.unwrap(Session.class);
  @Override
  public Participant login(String Email, String Password) {
    return null;
  }

  @Override
  public void logout() {
  }

  @Override
  public Participant findByEmail(String Email) {
    return null;
  }

  @Override
  public Participant getAllAndCount() {
    return null;
  }

  @Override
  public long getCount() {
    em.getTransaction().begin();
    long countParticipant = (long) em.createQuery("SELECT count(par) FROM Participant As par ").getSingleResult();
    em.getTransaction().commit();
    return countParticipant;
  }
}
