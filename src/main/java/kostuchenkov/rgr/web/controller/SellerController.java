package kostuchenkov.rgr.web.controller;

import freemarker.template.TemplateException;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.service.order.OrderService;
import kostuchenkov.rgr.model.service.product.ProductService;
import kostuchenkov.rgr.web.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private ProductService productService;

    @GetMapping("/seller/orders")
    public String sellerPage(@RequestParam(required = false) OrderStatus status, Model model) {
        if (status != null ) {
            model.addAttribute("orders", orderService.getAllOrdersWithStatus(status));
        } else {
            model.addAttribute("orders", orderService.getAllOrders());
        }
        model.addAttribute("ordersStatus", OrderStatus.values());
        return "seller-page";
    }

    @GetMapping("/seller/orders/{id:\\d+}")
    public String orderPage(@PathVariable("id") Order order, Model model) {
        model.addAttribute("order", order);
        model.addAttribute("seller", true);
        return "order";
    }

    @PostMapping("/seller/product/edit/name")
    @ResponseBody
    public String editName(@RequestParam("productId") Product product, @RequestParam("newName") String newName){
        if(productService.editName(product,newName)){
            return ResponseStatus.SUCCESS.toString();
        } else{
            return ResponseStatus.ERROR.toString();
        }
    }

    @PostMapping("/seller/product/edit/price")
    @ResponseBody
    public String editPrice(@RequestParam("productId") Product product, @RequestParam("newPrice") Integer newPrice){
        if(productService.editPrice(product, newPrice)){
            return ResponseStatus.SUCCESS.toString();
        } else{
            return ResponseStatus.ERROR.toString();
        }

    }

    @PostMapping("/seller/orders/{id:\\d+}")
    @ResponseBody
    public String orderIsDone(@PathVariable("id") Order order, @RequestParam("status") OrderStatus orderStatus) throws TemplateException, IOException, MessagingException {
        orderService.setStatus(order, orderStatus);
        return orderStatus.toString();
    }
}
