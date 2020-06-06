package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.CartService;
import kostuchenkov.rgr.service.OrderService;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.web.utils.validation.OrderCheckoutForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
        System.out.println(orders.toString());
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/user/order/checkout")
    public String checkoutPage(@AuthenticationPrincipal User session, Model model) {
        User user = userService.getUserById(session.getId());
        model.addAttribute("user", user);
        model.addAttribute("total", user.getCartTotal());
        return "checkout";
    }

    @PostMapping("/user/order/checkout")
    public String checkoutOrder(@AuthenticationPrincipal User session,
                                @Valid OrderCheckoutForm checkoutForm,
                                BindingResult bindingResult,
                                Model model,
                                @RequestParam("contact") List<String> contact,
                                @RequestParam("phone") String phone,
                                @RequestParam("payment") String payment,
                                @RequestParam("address") String address) {
        User user = userService.getUserById(session.getId());
        if (orderService.createOrder(user, contact.toString().replace(","," "),phone, address,payment)){
            return "redirect:/user/orders";
        }else {
            model.addAttribute("message","error");
            model.addAttribute("user", user);
            model.addAttribute("total", user.getCartTotal());
            return "checkout";
        }
    }
}
