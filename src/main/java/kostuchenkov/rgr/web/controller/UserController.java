package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id:\\d+}")
    public String userPage(@AuthenticationPrincipal User user, @PathVariable("id") int id, Model model) {

        model.addAttribute("user", user);
        return "user";
    }
}
