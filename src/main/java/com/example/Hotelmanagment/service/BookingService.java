package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.Book;
import com.example.Hotelmanagment.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Book saveBookinh(Book book) throws Exception;
    List<Book> getAllBook();
    boolean availableBooking(Room room, LocalDate startDate, LocalDate endDate);
    void delating(Long id);
}
