package org.pda.junit.repository;

import org.pda.junit.entity.User;

public class UserRepository implements IAuthRepository<User> {
  @Override
  public User login(String Email, String Password) {
    return null;
  }

  @Override
  public void logout() {

  }

  @Override
  public User findByEmail(String Email) {
    return null;
  }
}
