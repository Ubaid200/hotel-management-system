package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.User;
import com.example.Hotelmanagment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp  implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User loginnow(String email, String password) {
        User valid = userRepo.findByEmail(email);
        if (valid != null && valid.getPassword().equals(password)) {
            return valid;
        } else {

            return null;
        }

    }
}