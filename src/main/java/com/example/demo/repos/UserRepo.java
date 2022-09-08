package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
//    @Query("SELECT ")
    Optional<User> findUserByEmail(String email);
}
