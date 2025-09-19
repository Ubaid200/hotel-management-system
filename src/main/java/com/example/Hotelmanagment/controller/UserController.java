package com.example.Hotelmanagment.controller;

import com.example.Hotelmanagment.entity.User;
import com.example.Hotelmanagment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {



    @GetMapping("/login")
    public String getlogin(Model model){
        model.addAttribute("user",new User());
        return "login";
        }

}
