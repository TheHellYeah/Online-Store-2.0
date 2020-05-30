package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductSize;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.ProductRepository;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class AddProductController {

    @Autowired
    private ProductService productService;

   //TODO @Secured("hasRole(ROLE_CUSTOMER) or hasRole(ROLE_ADMIN)")
    @GetMapping("/product/add")
    public String page(Model model) {
        return "add-product-form";
    }

    //FIXME валидация продукта(желательно в сервисе)
    @PostMapping("/product/add")
    public String addProduct(Product product){
        productService.addProduct(product);
        return "redirect:/";
    }
}
