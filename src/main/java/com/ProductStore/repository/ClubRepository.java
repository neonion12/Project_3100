package com.ProductStore.repository;

import com.ProductStore.entity.Clubs;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Clubs, Long> {
    List<Clubs> findAll();
    Optional<Clubs> findByName(String name);
    List<Clubs> findByAdminIdd(Long adminIdd);
}

