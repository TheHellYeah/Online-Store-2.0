package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.service.WishListService;
import kostuchenkov.rgr.service.principal.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishListService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addToWishList(@AuthenticationPrincipal UserDetailsImpl session, @RequestParam("productId") Product product) throws Exception {

        if (wishListService.addToWishList(userService.getUserById(session.getUserId()), product)){
            return "Добавлено в избранное";
            } else{
                return "Уже есть в избранном";
        }
    }

    @PostMapping("/clear")
    public String clearWishList(@AuthenticationPrincipal UserDetailsImpl session) {

        wishListService.clearWishList(userService.getUserById(session.getUserId()));
        return "ok"; //?? отправляем сообщение пробабли
    }

    @PostMapping("/delete")
    public String deleteFromWishList(@AuthenticationPrincipal UserDetailsImpl session, @RequestParam("productId") Product product) {

        wishListService.deleteFromWishList(userService.getUserById(session.getUserId()), product);
        return "ok";
    }
}
