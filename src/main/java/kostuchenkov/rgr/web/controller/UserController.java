package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WishListService wishListService;
    @Autowired
    private ProductService productService;

    @GetMapping("/user/{id:\\d+}")
    public String userPage(@PathVariable("id") User user, Model model) {

        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/user/{id:\\d+}/wishlist/add")
    @ResponseBody
    public String addToWishList(@PathVariable("id") User user, @RequestParam("productId") String productId) {

        Optional<Product> product = productService.getProductById(productId);
        product.ifPresent(value -> wishListService.addToWishList(user, product.get()));
        return "ok"; //??оставим?
    }

    @GetMapping("/user/{id:\\d+}/wishlist/clear")
    @ResponseBody
    public String clearWishList(@PathVariable("id") User user){
        wishListService.clearWishList(user);
        return "ok"; //?? отправляем сообщение пробабли
    }

    @GetMapping("/user/{id:\\d+}/wishlist/delete")
    @ResponseBody
    public String deleteFromWishList(@PathVariable("id") User user, @RequestParam("productId") String productId){

        Optional<Product> product = productService.getProductById(productId);
        product.ifPresent(value -> wishListService.deleteFromWishList(user, product.get()));
        return "ok";
    }
}
