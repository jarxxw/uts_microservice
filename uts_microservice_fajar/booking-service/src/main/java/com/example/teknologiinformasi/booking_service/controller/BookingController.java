package com.example.teknologiinformasi.booking_service.controller;

import com.example.teknologiinformasi.booking_service.model.Booking;
import com.example.teknologiinformasi.booking_service.repository.BookingRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import com.example.teknologiinformasi.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private static final Logger log = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        log.info("GET /bookings accessed");
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        log.info("GET /bookings/{} accessed", id);
        return bookingRepository.findById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        log.info("POST /bookings accessed with body: {}", booking);
        return bookingRepository.save(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        log.info("PUT /bookings/{} accessed with body: {}", id, booking);
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        log.info("DELETE /bookings/{} accessed", id);
        bookingRepository.deleteById(id);
    }
}
