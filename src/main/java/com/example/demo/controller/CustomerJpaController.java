package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerJpaService;

@CrossOrigin
@RestController
@RequestMapping("api/jpa/customer")
public class CustomerJpaController
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerJpaService customerJpaService;

    private static final Logger log = LoggerFactory.getLogger(CustomerJpaController.class);

    @GetMapping("/getCustomer/{Id}")
    public Customer getCustomerById(@PathVariable("Id") long customerId)
    {
        return customerRepository.findById(customerId);
    }

    @GetMapping("/getCustomer/lastname/{lastname}")
    public List<Customer> getCustomerByLastName(@PathVariable("lastname") String lastName,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "20") int size)
    {
        Page<Customer> customerPage = customerRepository.findByLastName(lastName,
                PageRequest.of(page, size, Sort.by(Direction.ASC, "id")));

        return customerPage.getContent();
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "20") int size)
    {
        log.info("Get All Customers Fetched....");
        Page<Customer> allCustomers = customerRepository
                .findAll(PageRequest.of(page, size, Sort.by(Direction.ASC, "id")));

        return allCustomers.getContent();
    }

    @PostMapping(path = "customer/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveCountryZipCode(@RequestBody List<Customer> customerList)
    {
        log.info("Save Customers....");

        customerJpaService.saveCustomers(customerList);

    }

}
