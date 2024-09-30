package com.example.monolithic_spring_security.dao;

import com.example.monolithic_spring_security.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserDao extends JpaRepository<AuthUser, Integer> {
    Optional<AuthUser> findByAuthUserName(String authUserName);
}
