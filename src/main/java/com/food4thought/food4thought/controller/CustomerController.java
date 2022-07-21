package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.model.Customer;
import com.food4thought.food4thought.model.Food;
import com.food4thought.food4thought.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/users")
    public List<Customer> listAllCustomers() {
        return customerService.getAllCustomers();

    }

    @GetMapping("/users/{id}")
    public Customer getSpecificCustomer(@PathVariable long id) {
        return customerService.getSpecificCustomer(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception {

        Customer c = customerService.addCustomer(customer);
        if (c == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
    }
}
