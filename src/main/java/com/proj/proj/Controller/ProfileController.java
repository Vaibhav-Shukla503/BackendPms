package com.proj.proj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ProfileController {
    @GetMapping("/admin")
    public String showProfile(){
        return "admin";
    }

}
