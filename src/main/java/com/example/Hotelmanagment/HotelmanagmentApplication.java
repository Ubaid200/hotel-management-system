package com.example.Hotelmanagment;

import com.example.Hotelmanagment.entity.User;
import com.example.Hotelmanagment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HotelmanagmentApplication implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HotelmanagmentApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.findByEmail("admin@gmail.com").isEmpty()) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setPassword(passwordEncoder.encode("admin123"));
            userRepo.save(user);
        }
    }
}
