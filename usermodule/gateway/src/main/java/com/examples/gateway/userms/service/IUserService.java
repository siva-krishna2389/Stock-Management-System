package com.examples.gateway.userms.service;

import com.examples.gateway.userms.entities.User;

import java.util.Set;

public interface IUserService {

    User add(String username, String password, Set<String> roles);

    User findById(Long id);

    User findByUsername(String username);




}
