package com.examples.gateway.userms.service;

import com.examples.gateway.userms.dto.CreateCustomerRequest;
import com.examples.gateway.userms.dto.CustomerDetails;
import com.examples.gateway.userms.entities.Customer;

public interface ICustomerService {

    Customer add(Customer customer);

    CustomerDetails add(CreateCustomerRequest requestData);

    Customer findByUsername(String username);


}
