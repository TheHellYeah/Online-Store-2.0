package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.service.ProductService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("sizes", product.get().getSizes());
        model.addAttribute("reviews", product.get().getReviews());
        return "product";
    }
}
