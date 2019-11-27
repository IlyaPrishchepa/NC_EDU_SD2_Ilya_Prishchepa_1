package com.netcracker.services.interfaces;

import com.netcracker.models.Login;

public interface LoginService {
  Login create(Login login);
  Login findByEmailAndPassword(String email,String password);
  void delete(int id);
}
