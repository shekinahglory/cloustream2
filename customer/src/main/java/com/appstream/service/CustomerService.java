package com.appstream.service;

import com.appstream.domain.Customer;
import com.appstream.domain.FraudCheckResponse;
import com.appstream.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public record CustomerService(CustomerRepository repository, RestTemplate restTemplate) {


    //    Creating a new customer and checking if the user is not a fraudulent
    //    User
    public String createUser(Customer customer) {

        repository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8084/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        return "User Created";
    }
}
