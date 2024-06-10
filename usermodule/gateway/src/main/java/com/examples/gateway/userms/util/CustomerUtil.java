package com.examples.gateway.userms.util;

import com.examples.gateway.userms.dto.CustomerDetails;
import com.examples.gateway.userms.entities.Customer;
import com.examples.gateway.userms.entities.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

    public CustomerDetails toDetails(Customer customer){
        User user=customer.getUser();
        CustomerDetails desired=new CustomerDetails();
        desired.setUsername(user.getUsername());
        desired.setCustomerId(customer.getCustomerId());
        return desired;
    }
}
