package kostuchenkov.rgr.controller;

import kostuchenkov.rgr.domain.product.Product;
import kostuchenkov.rgr.domain.product.ProductCategory;
import kostuchenkov.rgr.service.MailService;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    MailService mailServiceClient;
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String indexPage(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        //mailClient.send("mitlg@yandex.ru","Ваш код активации","Привет, твой код активации 124234");
        return "index";
    }
//FIXME повторение кода, может можно и лучше
    @GetMapping("/man")
    public String indexMenPage(Model model) {
        Iterable<Product> products = productService.findByCategory(ProductCategory.MALE);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/woman")
    public String indexWomenPage(Model model) {
        Iterable<Product> products = productService.findByCategory(ProductCategory.FEMALE);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/children")
    public String indexChildrenPage(Model model) {
        Iterable<Product> products = productService.findByCategory(ProductCategory.CHILD);
        model.addAttribute("products", products);
        return "index";
    }
}
