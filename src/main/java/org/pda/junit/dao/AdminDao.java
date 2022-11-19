package org.pda.junit.dao;

import org.pda.junit.entity.Admin;

import java.util.List;

public class AdminDao implements Idao<Admin>{
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
    return null;
  }

  @Override
  public void update(Admin entity) {

  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
