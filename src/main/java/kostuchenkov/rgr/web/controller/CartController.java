package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.CartService;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/user/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String cartPage(@AuthenticationPrincipal User session, Model model){
        User user = userService.getUserById(session.getId());
        if(user.getBalance() < user.getBill()) {
            model.addAttribute("warning", true);
        }
        model.addAttribute("cart", user.getCart());
        model.addAttribute("total", user.getBill());
        return "cart";
    }

    //FIXME POST

    @GetMapping("/add")
    @ResponseBody
    public String addToCart(@AuthenticationPrincipal User session, @RequestParam String productId, @RequestParam String count){
        Optional<Product> product = productService.getProductById(productId);
        product.ifPresent(value ->
                cartService.addToCart(userService.getUserById(session.getId()), product.get(), Integer.parseInt(count)));
        return "ok";
    }

    @GetMapping("/clear")
    @ResponseBody
    public String clearCart(@AuthenticationPrincipal User session){
        cartService.clearCart(userService.getUserById(session.getId()));
        return "ok";
    }

    @GetMapping("delete")
    @ResponseBody
    public String deleteFromCart(@AuthenticationPrincipal User session, @RequestParam String productId){
       Optional<Product> product = productService.getProductById(productId);
       product.ifPresent(value ->
               cartService.deleteFromCart(userService.getUserById(session.getId()), product.get()));
       return "Товар удален";
    }
}
