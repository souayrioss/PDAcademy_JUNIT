package org.pda.junit.service;

import org.pda.junit.entity.Admin;
import org.pda.junit.repository.AdminRepository;
import org.pda.junit.repository.IAuthRepository;

import java.util.List;

public class AdminService implements ICRUDService<Admin>,IAuthService<Admin> {
  private IAuthRepository<Admin> adminRepository = new AdminRepository();

  @Override
  public Admin find(long id) {
    return null;
  }

  @Override
  public List<Admin> getAll() {
    return null;
  }

  @Override
  public Admin add(Admin user) {
    return null;
  }

  @Override
  public void update(Admin user) {

  }

  @Override
  public boolean delete(long id) {
    return false;
  }


  @Override
  public Admin login(String Email, String Password) {
    return adminRepository.login(Email,Password);
  }

  @Override
  public void logout() {

  }

  @Override
  public Admin findByEmail(String Email) {
    return null;
  }
}
