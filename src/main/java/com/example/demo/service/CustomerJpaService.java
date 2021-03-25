package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerJpaService
{
    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomers(List<Customer> customerList)
    {
        customerList.stream().forEach(element -> {
            Customer customer = new Customer(element.getFirstName(), element.getLastName());
            customerRepository.save(customer);
        });

    }

}
