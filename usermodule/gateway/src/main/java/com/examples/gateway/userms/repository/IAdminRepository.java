package com.examples.gateway.userms.repository;

import com.examples.gateway.userms.entities.Admin;
import com.examples.gateway.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Long> {

    Admin findAdminByUser(User user);

}
