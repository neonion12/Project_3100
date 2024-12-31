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

    // Update a club
    public Clubs updateClub(Long clubId, Clubs updatedClub) {
        Optional<Clubs> existingClubOpt = clubRepository.findById(clubId);
        if (existingClubOpt.isPresent()) {
            Clubs existingClub = existingClubOpt.get();
            // Update the fields
            existingClub.setName(updatedClub.getName());
            existingClub.setMotto(updatedClub.getMotto());
            existingClub.setMission(updatedClub.getMission());
            existingClub.setPresidentName(updatedClub.getPresidentName());
            existingClub.setPresidentFacebook(updatedClub.getPresidentFacebook());
            existingClub.setPresidentInstagram(updatedClub.getPresidentInstagram());
            existingClub.setPresidentEmail(updatedClub.getPresidentEmail());
            existingClub.setVicePresidentName(updatedClub.getVicePresidentName());
            existingClub.setVicePresidentFacebook(updatedClub.getVicePresidentFacebook());
            existingClub.setVicePresidentInstagram(updatedClub.getVicePresidentInstagram());
            existingClub.setVicePresidentEmail(updatedClub.getVicePresidentEmail());
            existingClub.setEventLink(updatedClub.getEventLink());
            
            return clubRepository.save(existingClub); // Save the updated club
        }
        return null; // Return null if club not found
    }
    // // Delete a club
    // public void deleteClub(Long clubId) {
    //     clubRepository.deleteById(clubId);
    // }
}