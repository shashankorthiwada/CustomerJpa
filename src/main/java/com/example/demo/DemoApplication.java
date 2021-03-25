package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication
{

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner demo(CustomerRepository repository)
    // {
    // return (args) -> {
    // repository.save(new Customer("David", "Beckham"));
    // repository.save(new Customer("Frenkie", "Dejong"));
    // repository.save(new Customer("Lionel", "Messi"));
    // repository.save(new Customer("Cristiano", "Ronaldo"));
    // repository.save(new Customer("Neymar", "Jr"));
    //
    // // // fetch All Customers
    // // for (Customer customer : repository.findAll())
    // // {
    // // log.info("All Customers: " + customer.toString());
    // // }
    // // log.info("");
    // //
    // // // fetch Individual Customer by ID
    // // // Customer customer = repository.findById(1L);
    // // // log.info("Fetch Using Customer By Id: " + customer.toString());
    // //
    // // // fetch by using Last Name
    // // // repository.findByLastName("Korthiwada").forEach(bauer -> {
    // // // // log.info("Fetch Using Customer Last Name: " + customer.toString());
    // // // log.info(bauer.toString());
    // // // });
    //
    // };
    //
    // }

}
