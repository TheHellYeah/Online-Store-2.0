package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.OrderRepository;
import kostuchenkov.rgr.service.CartService;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/user/cart")
    public String cartPage(@AuthenticationPrincipal User user, Model model){
        user = userService.getUserById(user.getId());
        model.addAttribute("cart", user.getCart());
        return "cart";
    }

    //FIXME POST

    @GetMapping("/user/cart/add")
    @ResponseBody
    public String addToCart(@AuthenticationPrincipal User user, @RequestParam String productId, @RequestParam String count){
        Optional<Product> product = productService.getProductById(productId);
        product.ifPresent(value -> cartService.addToCart(user, product.get(), Integer.parseInt(count)));
        return "ok";
    }

    @GetMapping("/user/cart/clear")
    @ResponseBody
    public String clearCart(@AuthenticationPrincipal User user){
        cartService.clearCart(user);
        return "ok";
    }

    @GetMapping("/user/cart/delete")
    @ResponseBody
    public String deleteFromCart(@AuthenticationPrincipal User user, @RequestParam String productId){
       Optional<Product> product = productService.getProductById(productId);
       product.ifPresent(value -> cartService.deleteFromCart(user, product.get()));
       return "ok";
    }
}
