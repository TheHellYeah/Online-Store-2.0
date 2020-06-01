package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
