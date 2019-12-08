package com.netcracker.repository;

import com.netcracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    User findUserByLoginId_Id(int loginId);
    User findUserByLoginId_Email(String email);


}
