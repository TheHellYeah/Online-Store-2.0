package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishListService;
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String addToWishList(@AuthenticationPrincipal User session, @RequestParam("productId") Product product) {

        wishListService.addToWishList(userService.getUserById(session.getId()), product);
        return "ok"; //??оставим?
    }

    @GetMapping("/clear")
    public String clearWishList(@AuthenticationPrincipal User session) {

        wishListService.clearWishList(userService.getUserById(session.getId()));
        return "ok"; //?? отправляем сообщение пробабли
    }

    @GetMapping("/delete")
    public String deleteFromWishList(@AuthenticationPrincipal User session, @RequestParam("productId") Product product) {

        wishListService.deleteFromWishList(userService.getUserById(session.getId()), product);
        return "ok";
    }
}
