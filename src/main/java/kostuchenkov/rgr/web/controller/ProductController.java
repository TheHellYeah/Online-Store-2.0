package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductCategory;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id:\\d+}")
    public String productPage(@PathVariable("id") Product product, Model model) {

        model.addAttribute("product", product);
        model.addAttribute("reviews", product.getReviews());
        return "product";
    }
}
