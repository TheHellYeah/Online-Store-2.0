package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.CartService;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @GetMapping("/user/{id:\\d+}/cart")
    public String cartPage(@PathVariable("id") User user, Model model){
        model.addAttribute("cart", user.getCart());
        return "cart";
    }

    //FIXME POST измени скрипт сам, подели на два файла желательно cart.js и wishList.js

    @GetMapping("/user/{id:\\d+}/cart/add")
    @ResponseBody
    public String addToCart(@PathVariable User user, @RequestParam String productId, @RequestParam String count){
        Optional<Product> product = productService.getProductById(productId);
        product.ifPresent(value -> cartService.addToCart(user, product.get(), Integer.parseInt(count)));
        return "ok";
    }

    @GetMapping("/user/{id:\\d+}/cart/clear")
    @ResponseBody
    public String clearCart(@PathVariable User user){
        cartService.clearCart(user);
        return "ok";
    }

    @GetMapping("/user/{id:\\d+}/cart/delete")
    @ResponseBody
    public String deleteFromCart(@PathVariable User user, @RequestParam String productId){
       Optional<Product> product = productService.getProductById(productId);
       product.ifPresent(value -> cartService.deleteFromCart(user, product.get()));
       return "ok";
    }
}
