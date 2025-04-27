package com.example.teknologiinformasi.booking_service.repository;

import com.example.teknologiinformasi.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}