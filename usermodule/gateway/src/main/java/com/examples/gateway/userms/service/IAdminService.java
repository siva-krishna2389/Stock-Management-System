package com.examples.gateway.userms.service;

import com.examples.gateway.userms.entities.Admin;

public interface IAdminService {
    Admin add(Admin admin);

   Admin findByUsername(String username);

}
