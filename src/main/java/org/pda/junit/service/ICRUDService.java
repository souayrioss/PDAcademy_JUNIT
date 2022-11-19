package org.pda.junit.service;

import java.util.List;

public interface ICRUDService<T> {
  T find(long id);
  List<T> getAll();
  T add(T user);
  T update(T user);
  boolean delete(long id);
}
