package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.service.principal.UserDetailsImpl;
import kostuchenkov.rgr.model.service.product.ProductService;
import kostuchenkov.rgr.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
        model.addAttribute("roles",UserRole.values());
        return "admin";
    }

    @PostMapping("/edit/balance")
    @ResponseBody
    public String editBalance(@RequestParam("id") User user,
                              @AuthenticationPrincipal UserDetailsImpl admin,
                              @RequestParam("balance") Integer balance){
        userService.editBalance(user, admin, balance);

        return "OK";
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
