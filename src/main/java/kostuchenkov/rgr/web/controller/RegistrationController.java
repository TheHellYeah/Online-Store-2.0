package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage() {

        return "registration";
    }

    @PostMapping("/registration")
    public String register(User user, Model model) {

        userService.addUser(user);
        return "redirect:/";
    }
}

