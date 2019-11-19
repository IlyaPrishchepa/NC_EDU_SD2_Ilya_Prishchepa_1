package com.netcracker.services.interfaces;

import com.netcracker.entity.Login;

public interface LoginService {
  Login create(Login login);
  Login findByEmail(String email);
  void delete(int id);
}
