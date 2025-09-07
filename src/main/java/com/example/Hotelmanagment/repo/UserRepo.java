package com.example.Hotelmanagment.repo;

import com.example.Hotelmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
     User findByEmail(String email);
}
