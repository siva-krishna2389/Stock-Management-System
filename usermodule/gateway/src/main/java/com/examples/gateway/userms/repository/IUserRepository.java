package com.examples.gateway.userms.repository;

import com.examples.gateway.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

    User findUserByUsername(String username);
}
