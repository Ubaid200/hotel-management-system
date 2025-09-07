package com.example.Hotelmanagment.repo;

import com.example.Hotelmanagment.entity.Book;
import com.example.Hotelmanagment.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Book,Long> {
    List<Book> findByRoomAndStatusInAndCheckOutDateAfterAndCheckInDateBefore(Room room, List<String> status, LocalDate startDate,LocalDate endDate);
}
