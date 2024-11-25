package com.ProductStore.ctl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomePageCtl {
    
    @Autowired
    //private Environment env;

    @GetMapping("/welcome_rapl")
    public String welcome_rapl_Page() {
        return "welcome_rapl";
    }
    @GetMapping("/welcome_photo")
    public String welcome_photo_Page() {
        return "welcome_photo";
    }
    @GetMapping("/welcome_chess")
    public String welcome_chess_Page() {
        return "welcome_chess";
    }
}
