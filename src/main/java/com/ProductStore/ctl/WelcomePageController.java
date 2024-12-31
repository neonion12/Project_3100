package com.ProductStore.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class WelcomePageController {

    @GetMapping("/create_club")
    public String create_club(Model model, HttpSession session) {
        Long id = (Long) session.getAttribute("id"); // Retrieve the Admin ID from the session
        model.addAttribute("id", id); // Add the Admin ID to the model
        return "create_club"; // Return the name of your HTML template
    }

    
    // Long id = (Long) session.getAttribute("id");
    // model.addAttribute("id", id);

    // @GetMapping("/welcome")
    // public String welcome(Model model, HttpSession session) {
    //     // Check if user is logged in
    //     if (session.getAttribute("nickname") == null) {
    //         return "redirect:/login"; // Redirect to login if not logged in
    //     }

    //     String nickname = (String) session.getAttribute("nickname");
    //     String role = (String) session.getAttribute("role");
    //     model.addAttribute("nickname", nickname);
    //     model.addAttribute("role", role);

    //     return "welcome"; // Return the welcome page
    // }
}