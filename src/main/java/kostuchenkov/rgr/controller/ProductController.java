package kostuchenkov.rgr.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.service.ProductService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String productPage(@RequestParam String id, Model model) {

        val product = productService.getProductById(id);

        if(!product.isPresent()) {
            return "product-not-found"; //TODO если продукт не найден(надо вообще будет запилить кастомные странички для разных видов ошибок)
        }
        model.addAttribute("product", product.get());
        return "product";
    }
}
