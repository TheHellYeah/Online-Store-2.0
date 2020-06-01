package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/user/{id:\\d+}/cart")
    public String cartPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("cart", userService.findByUsername(user.getUsername()).getCart());

        return "cart";

    }

    @GetMapping("/user/{id:\\d+}/wishlist")
    public String wishlistPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("wishlist", userService.findByUsername(user.getUsername()).getWishlist());
        return "wishlist";
    }



    //FIXME Добавить потом возможность ошибки и т.д. Мб сделать постом, посмотрел у других магазинов там гет.

    @RequestMapping(value = "/api/addtocart",  params = { "id", "count" }, method = RequestMethod.GET)
    @ResponseBody
    public String addToCart(@AuthenticationPrincipal User user, @RequestParam int id, @RequestParam int count){
        Product pr = productService.getProductById(String.valueOf(id)).get();
        userService.addToCart(user,pr,count);
        return "ok";
    }

    @RequestMapping(value = "/api/addwishlist", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public String addToWishlist(@AuthenticationPrincipal User user, @RequestParam("id") int id){
        Product pr = productService.getProductById(String.valueOf(id)).get();
        userService.addToWishlist(user,pr);

        return "ok";
    }

    @RequestMapping(value = "/api/clearwishlist", method = RequestMethod.GET)
    @ResponseBody
    public String clearWishlist(@AuthenticationPrincipal User user){
        userService.clearWishlist(user);
        return "ok";
    }



    @RequestMapping(value = "/api/delinwishlist", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public String delInWishlist(@AuthenticationPrincipal User user, @RequestParam("id") int id){
        Product pr = productService.getProductById(String.valueOf(id)).get();
        userService.delInWishlist(user,pr);
        return "ok";
    }

    @RequestMapping(value = "/api/clearcart", method = RequestMethod.GET)
    @ResponseBody
    public String clearCart(@AuthenticationPrincipal User user){
        userService.clearCart(user);
        return "ok";
    }

    @RequestMapping(value = "/api/delincart", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public String delInCart(@AuthenticationPrincipal User user, @RequestParam("id") int id){
       Product pr = productService.getProductById(String.valueOf(id)).get();
       userService.delInCart(user,pr);

        return "ok";
    }


}
