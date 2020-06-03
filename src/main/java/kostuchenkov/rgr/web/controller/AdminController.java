package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    //TODO @Secured()
    @GetMapping("/admin")
    public String adminPage(Model model) {

        return "admin";
    }
}
