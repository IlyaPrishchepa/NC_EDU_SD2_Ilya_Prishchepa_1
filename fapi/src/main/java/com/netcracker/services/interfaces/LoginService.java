package com.netcracker.services.interfaces;

import com.netcracker.models.Login;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface LoginService {

  List<Login> findAll(int pageNo, int pageSize);
  Login create(Login login);
  Login findByEmailAndPassword(String email,String password);
  Login findLoginByEmail(String email);
  UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
  void delete(int id);
  int getSize();

}
