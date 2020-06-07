package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
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
        model.addAttribute("cart", user.getCart());
        model.addAttribute("total", user.getCartTotal());
        return "cart";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@AuthenticationPrincipal User session, @RequestParam ProductSize size,
                            @RequestParam(name = "id") Product product) {

        User user = userService.getUserById(session.getId());
        if (cartService.addToCart(user, product, size)){
            return "Товар добавлен в корзину";
        }else {
            return "Такой размер уже есть в вашей корзине";
        }


    }

    @GetMapping("/clear")
    @ResponseBody
    public String clearCart(@AuthenticationPrincipal User session){
        cartService.clearCart(userService.getUserById(session.getId()));
        return "ok";
    }

    @PostMapping("delete")
    @ResponseBody
    public String deleteFromCart(@AuthenticationPrincipal User session,
                                 @RequestParam Integer cartId

        ){
        cartService.deleteFromCart(session, cartId);
        return "Товар удален";
    }
}
