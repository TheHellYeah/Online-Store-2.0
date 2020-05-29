package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AddProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/addproduct")
    public String page(Model model) {
        return "add-product";
    }
//FIXME СДЕЛАТЬ ПОСТОМ
    @GetMapping("/add")
    public  String addProduct(@RequestParam String name, @RequestParam String description, @RequestParam int price,
                              @RequestParam String brand, @RequestParam String category, @RequestParam String subcategory,
                              @RequestParam String season, Model model){

        Product product = new Product(name, price, description, category, subcategory, brand, season,0);
        productRepository.save(product);
        return "add-product";
    }
}
