package com.example.teknologiinformasi.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teknologiinformasi.booking_service.model.Movie;
// g.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}