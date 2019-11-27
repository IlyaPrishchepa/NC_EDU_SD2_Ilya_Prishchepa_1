package com.netcracker.repository;

import com.netcracker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    User findByLoginId(int loginId);

}
