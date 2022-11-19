package org.pda.junit.repository;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import org.pda.junit.entity.Exercise;
import org.pda.junit.hibernate.HibernateFactory;

public class ExerciseRepository implements IFilterRepository<Exercise> {
    private EntityManager em = HibernateFactory.getEntityManager();
    private Session session = em.unwrap(Session.class);
    @Override
    public Exercise getAllAndCount() {
        return null;
    }

    @Override
    public long getCount() {
        em.getTransaction().begin();
        long countExercise = (long) em.createQuery("SELECT count(exe) FROM Exercise exe ").getSingleResult();
        em.getTransaction().commit();
        return countExercise;
    }
}
