package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.UserRole;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/admin")
    public String adminPage(@RequestParam(required = false) UserRole role, Model model) {
        if(role != null) {
            model.addAttribute("users", userService.getAllUsersByRole(role));
        } else {
            model.addAttribute("users", userService.getAllUsers());
        }
        return "admin";
    }
}
