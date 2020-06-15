package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.CartService;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.service.principal.UserDetailsImpl;
import kostuchenkov.rgr.web.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String cartPage(@AuthenticationPrincipal UserDetailsImpl session, Model model){

        User user = userService.getUserById(session.getUserId());
        model.addAttribute("cart", user.getCart());
        model.addAttribute("total", user.getCartTotal());
        return "user-cart";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@AuthenticationPrincipal UserDetailsImpl session, @RequestParam ProductSize size,
                            @RequestParam(name = "id") Product product) {
        User user = userService.getUserById(session.getUserId());
        if(cartService.addToCart(user, product, size)) {
            return ResponseStatus.CART_ADD.toString();
        } else {
            return ResponseStatus.CART_ERROR.toString();
        }
    }

    @PostMapping("/clear")
    @ResponseBody
    public String clearCart(@AuthenticationPrincipal UserDetailsImpl session){
        User user = userService.getUserById(session.getUserId());
        cartService.clearCart(user);
        return ResponseStatus.CART_CLEAR.toString();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteFromCart(@AuthenticationPrincipal UserDetailsImpl session, @RequestParam Integer cartId){
        User user = userService.getUserById(session.getUserId());
        cartService.deleteFromCart(user, cartId);
        return ResponseStatus.CART_DELETE.toString();
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity updateCart(@AuthenticationPrincipal UserDetailsImpl session,
                                     @RequestParam("cartId") CartItem cartItem, @RequestParam Integer value) {
        User user = userService.getUserById(session.getUserId());
        if(cartService.updateCart(cartItem, value)) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getCartTotal());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user.getCartTotal());
        }
    }
}
