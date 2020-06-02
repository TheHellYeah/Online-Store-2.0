package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.order.Order;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.CartService;
import kostuchenkov.rgr.service.OrderService;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;



    @GetMapping("user/orders")
    public  String orders(@AuthenticationPrincipal User user, Model model){
        List <Order> orders = orderService.getAllOrderOfUser(user);
        model.addAttribute("orders", orders);
        return "orders";
    }

    //переносим товары из корзины в ордер и добавляем данные доставки и т.р.
    //Корзину чистим
    @PostMapping("/user/order/create")
    public String create(@AuthenticationPrincipal User user, @RequestParam("contact") List<String> contact){

        orderService.createOrder(user, contact.toString());
        cartService.clearCart(user);

        return "redirect:/user/orders";
    }

    // грузим страницу с той же корзиной и оформляем заказ. Кол-во можно редактировать будет только в корзине

    @GetMapping("/user/order/create")
    public String createOrder(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("cart", userService.findByUsername(user.getUsername()).getCart());
        return "create-order";
    }
}
