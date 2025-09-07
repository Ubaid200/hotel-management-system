package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.Room;
import com.example.Hotelmanagment.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomImp implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public List<Room> getall() {
        return roomRepo.findAll();
    }

    @Override
    public Room roomsave(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public void delection(Long id) {
        roomRepo.deleteById(id);
    }
}
