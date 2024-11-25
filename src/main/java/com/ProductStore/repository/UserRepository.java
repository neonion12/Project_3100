package com.ProductStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductStore.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailAndPassword(String email, String password);
    UserEntity findByEmail(String email);
}
