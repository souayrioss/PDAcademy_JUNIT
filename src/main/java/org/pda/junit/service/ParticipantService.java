package org.pda.junit.service;

import org.pda.junit.dao.ActivityDao;
import org.pda.junit.dao.Idao;
import org.pda.junit.dao.ParticipantDao;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.Exercise;
import org.pda.junit.entity.Participant;
import org.pda.junit.repository.ExerciseRepository;
import org.pda.junit.repository.IFilterRepository;
import org.pda.junit.repository.ParticipantRepository;

import java.util.List;

public class ParticipantService implements ICRUDService<Participant>,IFilterService<Participant> {

  private Idao<Participant> participantDao = new ParticipantDao();

  private IFilterRepository<Participant> participantRepository = new ParticipantRepository();

  @Override
  public Participant find(long id) {
    return participantDao.find(id);
  }

  @Override
  public List<Participant> getAll() {
    return participantDao.getAll();
  }

  @Override
  public Participant add(Participant participant) {
    return participantDao.add(participant);
  }

  @Override
  public Participant update(Participant participant) {
   return participantDao.add(participant);
  }

  @Override
  public boolean delete(long id) {
    return participantDao.delete(id);
  }

  @Override
  public Participant getAllAndCount() {
    return null;
  }

  @Override
  public long getCount() {
    return participantRepository.getCount();
  }
}
