package kostuchenkov.rgr.web.controller;

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

@Controller
@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
public class SellerController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/seller/orders")
    public String sellerOrders(@AuthenticationPrincipal User user,@RequestParam(value = "status", defaultValue = "ALL") String statusOrder, Model model){
        System.out.println(statusOrder);
        if(statusOrder.equals("PENDING")) {
            model.addAttribute("orders", orderService.getAllOrdersWithStatus(OrderStatus.PENDING));
        }else {
            if (statusOrder.equals("DELIVERED")) {
                model.addAttribute("orders", orderService.getAllOrdersWithStatus(OrderStatus.DELIVERED));
            } else {
                if (statusOrder.equals("IN_TRANSIT")) {
                    model.addAttribute("orders", orderService.getAllOrdersWithStatus(OrderStatus.IN_TRANSIT));
                } else {
                    model.addAttribute("orders", orderService.getAllOrders());
                    }
            }
        }
        return "seller-page";
    }

    @GetMapping("/seller/order/{id:\\d+}")
    public  String sellerOrder(@AuthenticationPrincipal User user, @PathVariable("id") Order order, Model model){
        model.addAttribute("order",order);
        return "order";
    }

    @PostMapping("/seller/order/setstatus")
    @ResponseBody
    public String orderIsDone(@RequestParam("orderId") Order order, @RequestParam("status") OrderStatus orderStatus){
        orderService.setStatus(order,orderStatus);
        return "ok";
    }
}
