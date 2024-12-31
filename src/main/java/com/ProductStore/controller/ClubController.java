package com.ProductStore.controller;

import com.ProductStore.entity.Clubs;
import com.ProductStore.service.ClubService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClubController {

    @Autowired
    private ClubService clubService;

    // Get clubs by admin ID
    @GetMapping("/admin/{adminIdd}")
    public ResponseEntity<List<Clubs>> getClubsByAdminId(@PathVariable Long adminIdd) {
        List<Clubs> clubs = clubService.getClubsByAdminId(adminIdd);
        return ResponseEntity.ok(clubs);
    }

    // // Update a club
    // @PutMapping("/{clubId}")
    // public ResponseEntity<Clubs> updateClub(@PathVariable Long clubId, @RequestBody Clubs updatedClub) {
    //     Clubs club = clubService.updateClub(clubId, updatedClub);
    //     if (club != null) {
    //         return ResponseEntity.ok(club);
    //     }
    //     return ResponseEntity.notFound().build(); // Return 404 if club not found
    // }

    // // Delete a club
    // @DeleteMapping("/{clubId}")
    // public ResponseEntity<Void> deleteClub(@PathVariable Long clubId) {
    //     clubService.deleteClub(clubId);
    //     return ResponseEntity.noContent().build(); // Return 204 No Content
    // }

    @GetMapping("/view-club/{clubName}")
    public String viewClubDetails(@PathVariable String clubName, Model model) {
        Clubs club = clubService.findByName(clubName);
        model.addAttribute("club", club);
        return "viewedClub"; // Resolves to viewedClub.html
    }

    @GetMapping("/clubs/new")
    public String showClubForm(Model model, HttpSession session) {
        List<Clubs> clubs = clubService.getAllClubs(); // Fetch all clubs
        model.addAttribute("clubs", clubs); //
        return "create_club"; // This should be the name of your HTML file (clubForm.html)
    }

     @GetMapping("/welcome/{clubName}")
    public String getClubPage(@PathVariable String clubName, Model model) {
        // You can add more club-specific data here if needed
        model.addAttribute("clubName", clubName); // Pass the club name to the view if necessary
        return "welcome_" + clubName; // This will resolve to welcome_chess.html, welcome_rapl.html, etc.
    }

    @PostMapping("/clubs")
    public String submitClubForm(Clubs club, Model model) {
        // Save the club entity
        clubService.saveClub(club);
        model.addAttribute("message", "Club information saved successfully!");
        return "redirect:/welcome"; // Redirect to a success page or show a success message
    }
}