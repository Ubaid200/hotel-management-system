package com.example.Hotelmanagment.controller;

import com.example.Hotelmanagment.entity.Room;
import com.example.Hotelmanagment.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String listroom(Model model){
        model.addAttribute("rooms", roomService.getall());
        model.addAttribute("newRoom", new Room());
        return "admin/rooms"; // folder: templates/admin/rooms.html
    }

    @PostMapping("/rooms/save")
    public String savaroom(@ModelAttribute("newRoom") Room room){
        roomService.roomsave(room);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/rooms/delete/{id}")
    public String delete(@PathVariable Long id){
        roomService.delection(id);
        return "redirect:/admin/rooms";
    }

}
