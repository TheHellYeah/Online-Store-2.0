package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

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

    @PostMapping("/storage/addsize")
    @ResponseBody
    public  String storageadd(@AuthenticationPrincipal User user,@RequestParam HashMap<String, String> ps){
        System.out.println(ps.toString());
        return "ok";
    }




}
