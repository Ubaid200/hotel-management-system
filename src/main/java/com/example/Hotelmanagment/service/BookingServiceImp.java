package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.Book;
import com.example.Hotelmanagment.entity.Room;
import com.example.Hotelmanagment.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@Service
public class BookingServiceImp implements BookingService{
    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public Book saveBookinh(Book book)throws Exception {
        if (!availableBooking(book.getRoom(), book.getCheckInDate(), book.getCheckOutDate())){
            throw new Exception("Room not Available for This Date");
        }
        book.setStatus("Booked");
        return bookingRepo.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookingRepo.findAll();
    }

    @Override
    public boolean availableBooking(Room room, LocalDate startDate, LocalDate endDate) {
        List<String> activeSatus = Arrays.asList("Book", "Check-In");
        List<Book> books = bookingRepo.findByRoomAndStatusInAndCheckOutDateAfterAndCheckInDateBefore(room,activeSatus,startDate,endDate);
        return books.isEmpty();
    }

    @Override
    public void delating(Long id) {
       bookingRepo.deleteById(id);
    }
}
