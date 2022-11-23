package org.pda.junit.service;

import org.pda.junit.dao.ActivityDao;
import org.pda.junit.dao.Idao;
import org.pda.junit.dao.ResponsibleDao;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.Responsible;

import java.util.List;

public class ResponsibleService implements ICRUDService<Responsible> {

  private Idao<Responsible> responsibleDao = new ResponsibleDao();
  @Override
  public Responsible find(long id) {
    return responsibleDao.find(id);
  }

  @Override
  public List<Responsible> getAll() {
    return responsibleDao.getAll();
  }

  @Override
  public Responsible add(Responsible responsible) {
    return responsibleDao.add(responsible);
  }

  @Override
  public Responsible update(Responsible responsible) {
    return responsibleDao.update(responsible);
  }

  @Override
  public boolean delete(long id) {
    return responsibleDao.delete(id);
  }
}
