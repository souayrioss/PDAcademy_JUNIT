package org.pda.junit.dao;

import java.util.List;

public interface Idao<T> {
  T find(long id);
  List<T> getAll();
  T add(T entity);
  T update(T entity);
  boolean delete(long id);
}
