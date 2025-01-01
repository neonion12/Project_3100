package com.ProductStore.controller;

import com.ProductStore.entity.Clubs;
import com.ProductStore.entity.Users;
import com.ProductStore.service.ClubService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/club/{clubId}/users")
    public String getUsersOfClub(@PathVariable Long clubId, Model model) {
        List<Users> users = clubService.findUsersOfClub(clubId);
        int userCount = clubService.countUsersOfClub(clubId);
        
        model.addAttribute("users", users);
        model.addAttribute("userCount", userCount);
        
        return "viewedClub"; // Return the view name
    }

    // Get clubs by admin ID
    @GetMapping("/admin/{adminIdd}")
    public ResponseEntity<List<Clubs>> getClubsByAdminId(@PathVariable Long adminIdd) {
        List<Clubs> clubs = clubService.getClubsByAdminId(adminIdd);
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/edit-club/{clubName}")
    public String editClub(@PathVariable String clubName, Model model, HttpSession session) {
        // Retrieve the Admin ID from the session
        Clubs club = clubService.findByName(clubName);
        model.addAttribute("club", club);
        if (club != null) {
            // Add club attributes to the model
            model.addAttribute("clubId", club.getId());
            model.addAttribute("clubName", club.getName());
            model.addAttribute("motto", club.getMotto());
            model.addAttribute("mission", club.getMission());
            model.addAttribute("presidentName", club.getPresidentName());
            model.addAttribute("presidentFacebook", club.getPresidentFacebook());
            model.addAttribute("presidentInstagram", club.getPresidentInstagram());
            model.addAttribute("presidentEmail", club.getPresidentEmail());
            model.addAttribute("vicePresidentName", club.getVicePresidentName());
            model.addAttribute("vicePresidentFacebook", club.getVicePresidentFacebook());
            model.addAttribute("vicePresidentInstagram", club.getVicePresidentInstagram());
            model.addAttribute("vicePresidentEmail", club.getVicePresidentEmail());
            model.addAttribute("eventLink", club.getEventLink());
        } else {
            // Handle the case where the club is not found
            model.addAttribute("error", "Club not found");
            return "error"; // Redirect to an error page or handle accordingly
        }
    
        return "editClub"; // Return the name of your Thymeleaf template
    }


    // Update a club
@PostMapping("/update-club")
public String updateClub(@ModelAttribute Clubs updatedClub, RedirectAttributes redirectAttributes) {
    Clubs club = clubService.updateClub(updatedClub.getId(), updatedClub);
    if (club != null) {
        // Optionally, you can add a success message to the redirect attributes
        redirectAttributes.addFlashAttribute("message", "Club updated successfully!");
        return "redirect:/welcome"; // Redirect to welcome page
    }
    // Optionally, you can add an error message to the redirect attributes
    redirectAttributes.addFlashAttribute("error", "Club not found.");
    return "redirect:/welcome"; // Redirect to welcome page even if club not found
}

    // Delete a club
    // @DeleteMapping("/{clubId}")
    // public ResponseEntity<Void> deleteClub(@PathVariable Long clubId) {
    //     clubService.deleteClub(clubId);
    //     return ResponseEntity.noContent().build(); // Return 204 No Content
    // }

    @GetMapping("/view-club/{clubName}")
    public String viewClubDetails(@PathVariable String clubName, Model model) {
        Clubs club = clubService.findByName(clubName);
        Long liveid = club.getId();
        int userCount = clubService.countUsersOfClub(liveid);
        model.addAttribute("userCount", liveid);
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