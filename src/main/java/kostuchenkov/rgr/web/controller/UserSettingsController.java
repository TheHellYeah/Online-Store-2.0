package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserWishListAccess;
import kostuchenkov.rgr.model.service.user.UserService;
import kostuchenkov.rgr.model.service.principal.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user/settings")
public class UserSettingsController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String settingsPage(@AuthenticationPrincipal UserDetailsImpl session, Model model) {
        model.addAttribute("user", userService.getUserById(session.getUserId()));
        return "user-settings";
    }

    @PostMapping
    public String changeSettings(@AuthenticationPrincipal UserDetailsImpl session,
                                 MultipartFile avatar, UserWishListAccess access, String contactInfo) {
        User user = userService.getUserById(session.getUserId());
        userService.changeProfileSettings(user, avatar, access, contactInfo);
        return "redirect:/user/" + session.getUserId();
    }
}
