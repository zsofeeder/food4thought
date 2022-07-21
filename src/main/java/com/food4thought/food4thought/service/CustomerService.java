package com.food4thought.food4thought.service;

import com.food4thought.food4thought.model.Customer;
import com.food4thought.food4thought.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getSpecificCustomer(Long id) {
        //todo: handle optional
        return customerRepository.findById(id).get();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
