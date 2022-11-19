package org.pda.junit.service;

import org.pda.junit.dao.ExerciseDao;
import org.pda.junit.dao.Idao;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.Exercise;
import org.pda.junit.repository.ActivityRepository;
import org.pda.junit.repository.ExerciseRepository;
import org.pda.junit.repository.IFilterRepository;

import java.util.List;

public class ExerciseService implements ICRUDService<Exercise>,IFilterService<Exercise> {
  private Idao<Exercise> exerciseDao = new ExerciseDao();

  private IFilterRepository<Exercise> exerciseRepository = new ExerciseRepository();


  @Override
  public Exercise find(long id) {
    return exerciseDao.find(id);
  }

  @Override
  public List<Exercise> getAll() {
    return exerciseDao.getAll();
  }

  @Override
  public Exercise add(Exercise exercise) {
    return exerciseDao.add(exercise);
  }

  @Override
  public void update(Exercise exercise) {
    exerciseDao.update(exercise);
  }

  @Override
  public boolean delete(long id) {
    return exerciseDao.delete(id);
  }

  @Override
  public Exercise getAllAndCount() {
    return null;
  }

  @Override
  public long getCount() {
    return exerciseRepository.getCount();
  }
}
