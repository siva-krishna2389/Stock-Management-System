package com.examples.gateway.userms.service;

import com.examples.gateway.userms.entities.Admin;
import com.examples.gateway.userms.entities.User;
import com.examples.gateway.userms.repository.IAdminRepository;
import com.examples.gateway.userms.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements IAdminService{

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Admin add(Admin admin) {
       Admin saved=adminRepository.save(admin);
       return saved;
    }

    @Override
    public Admin findByUsername(String username) {
       User user= userRepository.findUserByUsername(username);
       Admin admin=adminRepository.findAdminByUser(user);
       return admin;
    }
}
