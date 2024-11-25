package com.ProductStore.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import com.ProductStore.entity.UserEntity;
import com.ProductStore.repository.UserRepository;

@Controller
public class UserLoginPageCtl {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "/about_us";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model, HttpSession session) {
        UserEntity user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            // User authenticated
            String nickname = user.getNickname();
            session.setAttribute("nickname", nickname);
            return "redirect:/welcome"; // Redirect to a welcome page or dashboard
        } else {
            // Authentication failed
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
        String nickname = (String) session.getAttribute("nickname");
        model.addAttribute("nickname", nickname);
        return "welcome"; // This should be the name of your welcome HTML template
    }
}
