package com.example.teknologiinformasi.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.teknologiinformasi.customer_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
