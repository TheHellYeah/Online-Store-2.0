package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public String adminPage(@RequestParam(required = false) UserRole role, Model model) {
        if(role != null) {
            model.addAttribute("users", userService.getAllUsersByRole(role));
        } else {
            model.addAttribute("users", userService.getAllUsers());
        }
        return "admin";
    }

    @PostMapping("/dismiss")
    @ResponseBody
    public String dismiss(@RequestParam("id") Integer id){
        User user = userService.getUserById(id);
        userService.dismiss(user);
        return "OK";
    }

    @PostMapping("/appoint")
    @ResponseBody
    public String appoint(@RequestParam("id") Integer id){
        User user = userService.getUserById(id);
        userService.appoint(user);
        return "OK";
    }
}
