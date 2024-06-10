package com.examples.gateway.userms.repository;

import com.examples.gateway.userms.entities.Customer;
import com.examples.gateway.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUser(User user);
}
