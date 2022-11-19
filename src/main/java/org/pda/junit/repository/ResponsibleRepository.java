package org.pda.junit.repository;

import org.pda.junit.entity.Responsible;

public class ResponsibleRepository implements IAuthRepository<Responsible>{
  @Override
  public Responsible login(String Email, String Password) {
    return null;
  }

  @Override
  public void logout() {

  }

  @Override
  public Responsible findByEmail(String Email) {
    return null;
  }
}
