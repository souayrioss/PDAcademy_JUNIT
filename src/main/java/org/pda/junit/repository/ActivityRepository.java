package org.pda.junit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pda.junit.entity.Activity;
import org.pda.junit.hibernate.HibernateFactory;

public class ActivityRepository implements IFilterRepository<Activity> {
    Transaction transaction = null;
    private EntityManager em = HibernateFactory.getEntityManager();
    private Session session = em.unwrap(Session.class);
    @Override
    public Activity getAllAndCount() {
        return null;
    }

    @Override
    public long getCount() {
        em.getTransaction().begin();
        long countActivity = (long) em.createQuery("SELECT count(act) FROM Activity act ").getSingleResult();
        em.getTransaction().commit();
        return countActivity;
    }
}
