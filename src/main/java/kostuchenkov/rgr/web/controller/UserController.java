package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserWishListAccess;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id:\\d+}")
    public String userPage(@AuthenticationPrincipal User session, @PathVariable("id") User user, Model model) {

        if(user == null) {
            model.addAttribute("missing", true);
            return "user";
        }

        if(user.getId() == session.getId()) {
            model.addAttribute("currentUser", true);
        }
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/{id:\\d+}/wishlist")
    public String wishlist(@AuthenticationPrincipal User session, @PathVariable("id") User user, Model model) {

        if(user == null) {
            model.addAttribute("missing", true);
            return "user";
        }

        if(user.getId() == session.getId()) {
            model.addAttribute("currentUser", true);
        } else {
            if(user.getWishListAccess() == UserWishListAccess.PUBLIC || session.isAdmin()) {
                model.addAttribute("public", true);
            }
            model.addAttribute("username", user.getUsername());
        }
        model.addAttribute("wishlist", user.getWishList());
        return "wishlist";
    }

    //TODO
    @PostMapping("/settings")
    public String changeSettings() {
        return "user";
    }
}
