package com.ProductStore.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ProductStore.entity.Clubs;
import com.ProductStore.entity.Users;
import com.ProductStore.repository.UserRepository;
import com.ProductStore.service.ClubService;

@Controller
public class UserLoginPageCtl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClubService clubService; // Inject the ClubService

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
     Users user = userRepository.findByEmailAndPassword(email, password);
     if (user != null) {
         // User authenticated
         Long id = user.getId();
         String nickname = user.getNickname();
         String role = user.getRole(); // Fetch the role
         int roll = user.getRoll();
         int series = user.getSeries();
         String department = user.getDepartment();
         String gender = user.getGender();
         session.setAttribute("id", id);
         session.setAttribute("nickname", nickname);
         session.setAttribute("role", role); // Save role in session
         session.setAttribute("roll", roll);
         session.setAttribute("series", series);
         session.setAttribute("department", department);
         session.setAttribute("gender", gender);
         return "redirect:/welcome"; // Redirect to welcome page
     } else {
         // Authentication failed
         model.addAttribute("error", "Invalid email or password.");
         return "login";
     }
}


@GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
        // Check if user is logged in
        if (session.getAttribute("nickname") == null) {
            return "redirect:/login"; // Redirect to login if not logged in
        }
        Long id = (Long) session.getAttribute("id");
        String nickname = (String) session.getAttribute("nickname");
        String role = (String) session.getAttribute("role"); // Get role from session
        int roll = (int) session.getAttribute("roll");
        int series = (int) session.getAttribute("series");
        String department = (String) session.getAttribute("department");
        String gender = (String) session.getAttribute("gender");
        model.addAttribute("id", id);
        model.addAttribute("nickname", nickname);
        model.addAttribute("role", role); // Pass role to the template
        model.addAttribute("roll", roll);
        model.addAttribute("series", series);
        model.addAttribute("department", department);
        model.addAttribute("gender", gender);

        // List<Clubs> clubs = clubService.getAllClubs(); // Fetch all clubs
        // model.addAttribute("clubs", clubs); //

        List<Clubs> allClubs = clubService.getAllClubs(); // Fetch all clubs
        model.addAttribute("allClubs", allClubs); 

            // Fetch clubs created by the admin
    List<Clubs> adminClubs = clubService.getClubsByAdminId(id); // Fetch clubs by admin ID
    model.addAttribute("adminClubs", adminClubs);
        return "welcome"; // Welcome HTML template name
    }

}
