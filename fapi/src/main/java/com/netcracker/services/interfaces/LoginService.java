package com.netcracker.services.interfaces;

import com.netcracker.models.Login;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {
  Login create(Login login);
  Login findByEmailAndPassword(String email,String password);
  Login findLoginByEmail(String email);
  UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
  void delete(int id);
}
