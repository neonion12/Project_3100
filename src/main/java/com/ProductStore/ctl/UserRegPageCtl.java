package com.ProductStore.ctl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ProductStore.entity.Users;
import com.ProductStore.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

@Controller
public class UserRegPageCtl {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String regPage() {
        return "index";
    }

    @GetMapping("/userRegistration2")
    public String uregPage() {
        return "Signup";
    }

    @GetMapping("/userRegistration1")
    public String uregPage1() {
        return "userRegistration";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(HttpServletRequest request, @ModelAttribute("form") Users user, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email already exists.");
            return "userRegistration";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match.");
            return "userRegistration";
        }
 // Encrypt the password using BCrypt
 String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
 user.setPassword(hashedPassword); // Set the hashed password back to the user object
 user.setConfirmPassword(hashedPassword);
        userRepository.save(user);
        return "redirect:/login";
        // userRepository.save(user);
        // model.addAttribute("msg", "User Register Successfully");
        // return "login";
    }
}
