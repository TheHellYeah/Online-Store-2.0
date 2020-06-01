package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;

import kostuchenkov.rgr.data.domain.product.ProductSize;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AddProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

   //TODO @Secured("hasRole(ROLE_CUSTOMER) or hasRole(ROLE_ADMIN)")
    @GetMapping("/product/add")
    public String page(Model model) {
        return "add-product-form";
    }

    //FIXME валидация продукта(желательно в сервисе)
    @PostMapping("/product/add")
    public String addProduct(Product product, @RequestParam("SIZE") List<Integer> size){

        //FIXME КАСТЫЫЫЫЛЬ СРОЧНО ПЕРЕДЕЛАТЬ
        Map<ProductSize, Integer> s = new HashMap<>();
        for(int i = 0; i< ProductSize.values().length;i++){
            s.put(ProductSize.values()[i],size.get(i));
        }
        product.getSizes().putAll(s);
        productService.addProduct(product);

        return "redirect:/";
    }
}
