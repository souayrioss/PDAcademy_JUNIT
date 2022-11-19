package org.pda.junit.service;

import org.pda.junit.dao.ActivityDao;
import org.pda.junit.dao.ExerciseDao;
import org.pda.junit.dao.Idao;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.Exercise;
import org.pda.junit.repository.ActivityRepository;
import org.pda.junit.repository.IFilterRepository;

import java.util.List;

public class ActivityService implements ICRUDService<Activity>,IFilterService<Activity> {

  private Idao<Activity> activityDao = new ActivityDao();
  private IFilterRepository<Activity> activityRepository = new ActivityRepository();

  @Override
  public Activity find(long id) {
    return activityDao.find(id);
  }

  @Override
  public List<Activity> getAll() {
    return activityDao.getAll();
  }

  @Override
  public Activity add(Activity activity) {
    return activityDao.add(activity);
  }

  @Override
  public Activity update(Activity activity) {
    return activityDao.update(activity);
  }

  @Override
  public boolean delete(long id) {
    return activityDao.delete(id);
  }

  @Override
  public Activity getAllAndCount() {
    return activityRepository.getAllAndCount();
  }

  @Override
  public long getCount() {
    return activityRepository.getCount();
  }
}
