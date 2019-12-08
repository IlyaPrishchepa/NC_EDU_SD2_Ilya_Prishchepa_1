package com.netcracker.services.implementation;

import com.netcracker.entity.Login;
import com.netcracker.repository.LoginRepo;
import com.netcracker.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
  @Autowired
  private LoginRepo loginRepo;

  @Override
  public List<Login> findAll(int pageNo, int pageSize) {
    return (List<Login>) loginRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
  }

  @Override
  public Login create(Login login) {
    return loginRepo.save(login);
  }

  @Override
  public Login findByEmailAndPassword(String email,String password) {
    return loginRepo.findByEmailAndPassword(email,password);
  }

  @Override
  public Login findLoginByEmail(String email) {
    return loginRepo.findLoginByEmail(email);
  }

  @Override
  public void delete(int id) {
      loginRepo.deleteById(id);
  }

  @Override
  public int getSize(){
    return (int)loginRepo.count();
  }

}
