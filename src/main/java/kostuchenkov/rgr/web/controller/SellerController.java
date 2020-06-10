package kostuchenkov.rgr.web.controller;

import freemarker.template.TemplateException;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
public class SellerController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/seller/orders")
    public String sellerPage(@AuthenticationPrincipal User user, @RequestParam(required = false) OrderStatus status, Model model) {

        if (status != null) {
            model.addAttribute("orders", orderService.getAllOrdersWithStatus(status));
        } else {
            model.addAttribute("orders", orderService.getAllOrders());
        }
        return "seller-page";
    }

    @GetMapping("/seller/orders/{id:\\d+}")
    public String orderPage(@AuthenticationPrincipal User user, @PathVariable("id") Order order, Model model) {
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping("/seller/orders/{id:\\d+}")
    @ResponseBody
    public String orderIsDone(@PathVariable("id") Order order, @RequestParam("status") OrderStatus orderStatus) throws TemplateException, IOException, MessagingException {
        orderService.setStatus(order, orderStatus);
        return orderStatus.toString();
    }
}
