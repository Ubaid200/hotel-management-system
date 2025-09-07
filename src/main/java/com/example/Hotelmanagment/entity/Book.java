package com.example.Hotelmanagment.entity;

import com.example.Hotelmanagment.entity.Customer;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private String status; // "Book", "Check-In", "Check-Out"

    // ✅ Standard no-arg getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status; // ✅ No-arg getter for stream filter & Thymeleaf
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Optional: convenience method to set status easily
    public void markBooked() {
        this.status = "Book";
    }

    public void markCheckedIn() {
        this.status = "Check-In";
    }

    public void markCheckedOut() {
        this.status = "Check-Out";
    }
}
