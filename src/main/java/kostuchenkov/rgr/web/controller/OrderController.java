package kostuchenkov.rgr.web.controller;

import freemarker.template.TemplateException;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderPayment;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.service.cart.CartService;
import kostuchenkov.rgr.model.service.order.OrderService;
import kostuchenkov.rgr.model.service.product.ProductService;
import kostuchenkov.rgr.model.service.user.UserService;
import kostuchenkov.rgr.model.service.principal.UserDetailsImpl;
import kostuchenkov.rgr.web.utils.ControllerUtils;
import kostuchenkov.rgr.web.utils.validation.OrderCheckoutForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

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
    public String ordersListPage(@AuthenticationPrincipal UserDetailsImpl session, Model model){

        model.addAttribute("orders", orderService.getAllOrderOfUser(session.getUser()));
        return "user-orders";
    }

    @GetMapping("/user/orders/{id:\\d+}")
    public String orderPage(@AuthenticationPrincipal UserDetailsImpl session, @PathVariable("id") Order order, Model model) {
        if(order != null) {
            if(order.getUser().getId() == session.getUserId()) {
                model.addAttribute("order", order);
            } else {
                model.addAttribute("missing", "К сожалению, такого заказа не найдено");
            }
        } else {
            model.addAttribute("missing", "К сожалению, такого заказа не найдено");
        }
        return "order";
    }

    @GetMapping("/user/order/checkout")
    public String checkoutPage(@AuthenticationPrincipal UserDetailsImpl session, Model model) {
        User user = userService.getUserById(session.getUserId());
        model.addAttribute("user", user);
        model.addAttribute("total", user.getCartTotal());
        return "order-checkout";
    }

    @PostMapping("/user/order/checkout")
    public String checkoutOrder(@AuthenticationPrincipal UserDetailsImpl session,
                                @Valid OrderCheckoutForm checkoutForm,
                                BindingResult bindingResult,
                                Model model) throws TemplateException, IOException, MessagingException {

        User user = userService.getUserById(session.getUserId());

        if(bindingResult.hasErrors()) {
            ControllerUtils.putErrorsIntoModel(model, bindingResult);
            model.addAttribute("user", user);
            model.addAttribute("total", user.getCartTotal());
            return "order-checkout";
        }

        if (orderService.createOrder(user, checkoutForm)) {
            if(checkoutForm.getOrderPayment().equals(OrderPayment.BALANCE)) {
                session.getUser().setBalance(user.getBalance());
            }
            return "redirect:/user/orders";
        } else {
            model.addAttribute("message","error");
            model.addAttribute("user", user);
            model.addAttribute("total", user.getCartTotal());
            return "order-checkout";
        }
    }
}
