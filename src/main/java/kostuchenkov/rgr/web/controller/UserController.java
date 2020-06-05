package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.domain.user.UserWishListAccess;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

        if(user.getId() == session.getId()){
            model.addAttribute("currentUser", true);
        }
        else {
            if(user.getWishListAccess() == UserWishListAccess.PUBLIC) {
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
