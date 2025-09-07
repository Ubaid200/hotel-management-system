package com.example.Hotelmanagment.controller;

import com.example.Hotelmanagment.entity.Book;
import com.example.Hotelmanagment.repo.CustomerRepo;
import com.example.Hotelmanagment.repo.RoomRepo;
import com.example.Hotelmanagment.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/bookings")
    public String showpage(Model model){

        List<Book> bookings = bookingService.getAllBook();
        model.addAttribute("bookings",bookings);
        model.addAttribute("rooms",roomRepo.findAll());
        model.addAttribute("customers",customerRepo.findAll());
        model.addAttribute("newBooking",new Book());
        return "admin/booking";
    }
    @PostMapping("/bookings/save")
    public String saveBooking(@ModelAttribute("newBooking") Book book,Model model){
        try {
            bookingService.saveBookinh(book);
            return "redirect:/admin/bookings";

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            model.addAttribute("customers",customerRepo.findAll());
            model.addAttribute("rooms",roomRepo.findAll());
            model.addAttribute("bookings",bookingService.getAllBook());
            model.addAttribute("newBooking",book);
            return "admin/booking";
        }
    }
    @GetMapping("/bookings/delete/{id}")
    public String deleation(@PathVariable Long id){
        bookingService.delating(id);
        return "redirect:/admin/bookings";
    }
}
