package com.ProductStore.repository;

import com.ProductStore.entity.Clubs;
import com.ProductStore.entity.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Clubs, Long> {
    List<Clubs> findAll();
    Optional<Clubs> findByName(String name);
    List<Clubs> findByAdminIdd(Long adminIdd);
    @Query("SELECT u FROM Users u JOIN u.clubs c WHERE c.id = :clubId")
    List<Users> findUsersByClubId(@Param("clubId") Long clubId);
}

