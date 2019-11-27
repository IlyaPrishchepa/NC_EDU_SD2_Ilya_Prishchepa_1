package com.netcracker.services.implementation;

import com.netcracker.entity.Login;
import com.netcracker.repository.LoginRepo;
import com.netcracker.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
  @Autowired
  private LoginRepo loginRepo;

  @Override
  public Login create(Login login) {
    return loginRepo.save(login);
  }

  @Override
  public Login findByEmailAndPassword(String email,String password) {
    return loginRepo.findByEmailAndPassword(email,password);
  }

  @Override
  public void delete(int id) {
      loginRepo.deleteById(id);
  }
}
