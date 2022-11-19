package org.pda.junit.repository;

public interface IAuthRepository<T> {

  T login(String Email, String Password);

  void logout();

  T findByEmail(String Email);
}
