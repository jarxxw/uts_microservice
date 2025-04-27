package com.example.teknologiinformasi.customer_service.controller;

import com.example.teknologiinformasi.customer_service.model.Customer;
import com.example.teknologiinformasi.customer_service.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        log.info("GET /customers accessed");
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        log.info("GET /customers/{} accessed", id);
        return customerRepository.findById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        log.info("POST /customers accessed with body: {}", customer);
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        log.info("PUT /customers/{} accessed with body: {}", id, customer);
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        log.info("DELETE /customers/{} accessed", id);
        customerRepository.deleteById(id);
    }
}
