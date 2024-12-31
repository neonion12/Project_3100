package com.ProductStore.controller;

import com.ProductStore.entity.Clubs;
import com.ProductStore.entity.Users;
import com.ProductStore.repository.UserRepository;
import com.ProductStore.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClubRepository clubRepository;

    // Get user details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    // Get all clubs the user has joined
    @GetMapping("/{id}/clubs")
    public ResponseEntity<Set<Clubs>> getUserClubs(@PathVariable Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get().getClubs(), HttpStatus.OK);
    }

    // Join a club
    @PostMapping("/{userId}/join/{clubId}")
    public ResponseEntity<String> joinClub(@PathVariable Long userId, @PathVariable Long clubId) {
        Optional<Users> user = userRepository.findById(userId);
        Optional<Clubs> club = clubRepository.findById(clubId);

        if (user.isEmpty() || club.isEmpty()) {
            return new ResponseEntity<>("User or Club not found", HttpStatus.NOT_FOUND);
        }

        Users existingUser = user.get();
        Clubs existingClub = club.get();

        if (existingUser.getClubs().contains(existingClub)) {
            return new ResponseEntity<>("User already a member of this club", HttpStatus.BAD_REQUEST);
        }

        existingUser.getClubs().add(existingClub);
        userRepository.save(existingUser);

        return new ResponseEntity<>("Successfully joined the club", HttpStatus.OK);
    }

    // Get all users of a specific club
    @GetMapping("/club/{clubId}/members")
    public ResponseEntity<Set<Users>> getClubMembers(@PathVariable Long clubId) {
        Optional<Clubs> club = clubRepository.findById(clubId);
        if (club.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Set<Users> members = club.get().getUsers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }
}
