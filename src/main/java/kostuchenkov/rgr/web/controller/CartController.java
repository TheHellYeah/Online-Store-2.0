package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/user/{id:\\d+}/cart")
    public String cartPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("cart", user.getCart());

        return "cart";

    }

    //FIXME удаление из корзины
    //@PostMapping("/")
}
