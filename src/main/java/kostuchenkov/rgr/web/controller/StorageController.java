package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
public class StorageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/storage")
    public  String storage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "storage";
    }




}
