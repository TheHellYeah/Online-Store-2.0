package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.ProductCategory;
import kostuchenkov.rgr.service.MailService;
import kostuchenkov.rgr.service.ProductService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class IndexController {

    @Autowired
    MailService mailServiceClient;
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String indexPage(Model model) {
        val products = productService.getAllProducts();
        model.addAttribute("products", products);
        //mailClient.send("mitlg@yandex.ru","Ваш код активации","Привет, твой код активации 124234");
        return "index";
    }

    @GetMapping("/{gender}")
    public String categoryPage(@PathVariable String gender, Model model) {
        ProductCategory category = ProductCategory.valueOf(gender.toUpperCase());
        val products = productService.getAllProductsInCategory(category);
        model.addAttribute("products", products);
        return "index";
    }

}
