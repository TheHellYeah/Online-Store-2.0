package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.model.order.Order;
import kostuchenkov.rgr.data.model.order.OrderStatus;
import kostuchenkov.rgr.data.model.user.User;
import kostuchenkov.rgr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
public class SellerController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/seller/orders")
    public String sellerOrders(@AuthenticationPrincipal User user,@RequestParam(value = "status", defaultValue = "ALL") String statusOrder, Model model){

        if(statusOrder.equals(OrderStatus.PENDING.toString())) {
            model.addAttribute("orders", orderService.getAllOrdersWithStatus(OrderStatus.PENDING));
        }else{ if(statusOrder.equals(OrderStatus.DONE.toString())) {
            model.addAttribute("orders", orderService.getAllOrdersWithStatus(OrderStatus.DONE));
             }else {
            model.addAttribute("orders", orderService.getAllOrders());
            }
        }
        return "seller-page";
    }

    @GetMapping("/seller/order/{id:\\d+}")
    public  String sellerOrder(@AuthenticationPrincipal User user, @PathVariable("id") Order order, Model model){
        model.addAttribute("order",order);
        return "order";
    }

    @GetMapping("/seller/order/isdone")
    @ResponseBody
    public String orderIsDone(@RequestParam("orderId") Order order){
        orderService.setStatus(order,OrderStatus.DONE);
        return "ok";
    }
}
