package com.example.Hotelmanagment.repo;

import com.example.Hotelmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
     Optional<User> findByEmail(String email);
}
