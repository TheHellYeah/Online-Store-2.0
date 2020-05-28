package kostuchenkov.rgr.controller;


import kostuchenkov.rgr.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/cart")
    public String showCart(Model model){



        return "cart";
    }
}
