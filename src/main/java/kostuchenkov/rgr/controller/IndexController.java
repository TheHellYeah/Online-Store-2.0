package kostuchenkov.rgr.controller;

import kostuchenkov.rgr.service.MailService;
import kostuchenkov.rgr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    MailService mailServiceClient;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("shoes", productRepository);
        //mailClient.send("mitlg@yandex.ru","Ваш код активации","Привет, твой код активации 124234");
        return "index";
    }
}
