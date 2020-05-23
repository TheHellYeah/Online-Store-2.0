package kostuchenkov.rgr;

import kostuchenkov.rgr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("shoes", productRepository);
        return "index";
    }
}
