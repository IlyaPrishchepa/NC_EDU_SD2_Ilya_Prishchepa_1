package com.netcracker.services.implementation;

import com.netcracker.entity.Company;
import com.netcracker.repository.CompanyRepo;
import com.netcracker.services.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  private CompanyRepo companyRepo;

  @Override
  public Company save(Company company) {
    return companyRepo.save(company);
  }


  @Override
  public void delete(int id) {
    companyRepo.deleteById(id);

  }

  @Override
  public List<Company> findAll(int pageNo, int pageSize) {
    return (List<Company>) companyRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
  }

  @Override
  public Company findById(int id) {
    return companyRepo.findById(id).get();
  }


  @Override
  public Company findByName(String name) {
    return companyRepo.findByName(name);
  }

  @Override
  public int getSize(){
    return (int)companyRepo.count();
  }

  @Override
  public Company findByLoginId(int loginId) {
    return companyRepo.findCompanyByLoginId2_Id(loginId);
  }

}
