package com.netcracker.services.interfaces;

import com.netcracker.entity.Login;

import java.util.List;

public interface LoginService {

  List<Login> findAll(int pageNo, int pageSize);
  Login create(Login login);
  Login findByEmailAndPassword(String email, String password);
  Login findLoginByEmail(String email);
  void delete(int id);
  int getSize();

}
