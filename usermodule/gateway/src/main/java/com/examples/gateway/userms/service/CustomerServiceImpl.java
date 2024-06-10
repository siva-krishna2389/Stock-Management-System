package com.examples.gateway.userms.service;

import com.examples.gateway.userms.dto.CreateCustomerRequest;
import com.examples.gateway.userms.dto.CustomerDetails;
import com.examples.gateway.userms.entities.Customer;
import com.examples.gateway.userms.entities.User;
import com.examples.gateway.userms.repository.ICustomerRepository;
import com.examples.gateway.userms.repository.IUserRepository;
import com.examples.gateway.userms.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private CustomerUtil customererUtil;

    @Override
    public Customer add(Customer customer) {
        Customer saved = customerRepository.save(customer);
        return saved;
    }

    @Override
    public CustomerDetails add(CreateCustomerRequest requestData) {
        Set<String> roles = new HashSet<>();
        roles.add("customer");
        User user = new User(requestData.getUsername(), requestData.getPassword(), roles);
        user = userRepository.save(user);
        Customer customer = new Customer();
        customer.setUser(user);
        customer=customerRepository.save(customer);
        CustomerDetails details = customererUtil.toDetails(customer);
        return details;
    }

    @Override
    public Customer findByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        Customer customer = customerRepository.findCustomerByUser(user);
        return customer;
    }
}
