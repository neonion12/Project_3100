package com.ProductStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductStore.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmailAndPassword(String email, String password);
    Users findByEmail(String email);
}
