package com.ProductStore.service;

import com.ProductStore.entity.Clubs;
import com.ProductStore.repository.ClubRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public Clubs saveClub(Clubs club) {
        if (club.getEventLink() == null || club.getEventLink().trim().isEmpty()) {
            club.setEventLink(""); // Default value if no event link is provided
        }
        return clubRepository.save(club);
    }

    public List<Clubs> getAllClubs() {
        return clubRepository.findAll(); // Fetch all clubs from the database
    }

    public Clubs findByName(String name) {
        return clubRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Club not found: " + name));
    }


    public List<Clubs> getClubsByAdminId(Long adminIdd) {
        return clubRepository.findByAdminIdd(adminIdd);
    }

    // // Update a club
    // public Clubs updateClub(Long clubId, Clubs updatedClub) {
    //     Optional<Clubs> existingClub = clubRepository.findById(clubId);
    //     if (existingClub.isPresent()) {
    //         Clubs club = existingClub.get();
    //         club.setName(updatedClub.getName());
    //         club.setMotto(updatedClub.getMotto());
    //         club.setMission(updatedClub.getMission());
    //         club.setPresidentName(updatedClub.getPresidentName());
    //         club.setPresidentFacebook(updatedClub.getPresidentFacebook());
    //         club.setPresidentInstagram(updatedClub.getPresidentInstagram());
    //         club.setPresidentEmail(updatedClub.getPresidentEmail());
    //         club.setVicePresidentName(updatedClub.getVicePresidentName());
    //         club.setVicePresidentFacebook(updatedClub.getVicePresidentFacebook());
    //         club.setVicePresidentInstagram(updatedClub.getVicePresidentInstagram());
    //         club.setVicePresidentEmail(updatedClub.getVicePresidentEmail());
    //         club.setEventLink(updatedClub.getEventLink());
    //         return clubRepository.save(club);
    //     }
    //     return null; // or throw an exception
    // }

    // // Delete a club
    // public void deleteClub(Long clubId) {
    //     clubRepository.deleteById(clubId);
    // }
}