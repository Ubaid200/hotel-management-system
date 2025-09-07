package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.Room;
import java.util.List;

public interface RoomService {
    List<Room> getall();
    Room roomsave(Room room);
    void delection(Long id);
}
