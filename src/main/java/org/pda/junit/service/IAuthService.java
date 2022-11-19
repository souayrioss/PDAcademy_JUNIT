package org.pda.junit.service;

public interface IAuthService<T> {
    T login(String Email, String Password);
    void logout();
    T findByEmail(String Email);
}
