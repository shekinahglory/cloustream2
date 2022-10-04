package com.appstream.controller;


import com.appstream.domain.Customer;
import com.appstream.domain.CustomerRegistrationRequest;
import com.appstream.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public record CustomerController(CustomerService customerService) {


    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        String result = customerService.createUser(customer);
        log.info("Customer created ");
        return ResponseEntity.ok("Account created");


    }


}
