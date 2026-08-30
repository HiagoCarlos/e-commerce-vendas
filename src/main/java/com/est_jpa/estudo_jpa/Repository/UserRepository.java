package com.est_jpa.estudo_jpa.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.est_jpa.estudo_jpa.Entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
