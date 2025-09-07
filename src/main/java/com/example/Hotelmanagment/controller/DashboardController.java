package com.example.Hotelmanagment.controller;

import com.example.Hotelmanagment.repo.CustomerRepo;
import com.example.Hotelmanagment.repo.RoomRepo;
import com.example.Hotelmanagment.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("totalRooms", roomRepo.count());
        model.addAttribute("totalCustomers", customerRepo.count());

        // ✅ Calculate active bookings
        long activeBookings = bookingService.getAllBook()
                .stream()
                .filter(b -> "Book".equals(b.getStatus()) || "Check-In".equals(b.getStatus()))
                .count();
        model.addAttribute("activeBookings", activeBookings);

        model.addAttribute("customers", customerRepo.findAll()); // recent users


        LocalDate today = LocalDate.now();
        long todayBookings = bookingService.getAllBook()
                .stream()
                .filter(b -> b.getCheckInDate() != null && b.getCheckInDate().equals(today))
                .count();
        model.addAttribute("todayBookings", todayBookings);

        model.addAttribute("customers", customerRepo.findAll());
        return "admin/dashboard";


    }
}
