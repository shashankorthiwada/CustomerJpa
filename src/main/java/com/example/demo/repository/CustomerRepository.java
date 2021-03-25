package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>
{
    Page<Customer> findByLastName(String lastName, Pageable pageable);

    Customer findById(long id);

}
