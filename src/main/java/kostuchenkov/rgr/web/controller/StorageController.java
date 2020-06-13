package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
public class StorageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/storage")
    public  String storage(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "product-storage";
    }

    @PostMapping("/storage/addsize")
    public  String storageAdd(HttpServletRequest request,
                              @RequestParam("id")Product product,
                              @RequestParam("_csrf")String _csrf,
                              @RequestParam HashMap<String, String> ps){//TODO Удалить этот коммент на проде.
                                                                        // С мапой этйо много дрочева было, проще сотавить стринг стринг, иначе большие проблемы ! если вторйо параметр интегер, то ерорр ((
        ps.remove("id"); //Почему они блин в мапу попадают
        ps.remove("_csrf");
        for(Map.Entry<String,String> temp : ps.entrySet()){
            product.getSizes().put(ProductSize.valueOf(temp.getKey()),Integer.valueOf(temp.getValue()));
        }

        productService.update(product);
        return "redirect:"+ request.getHeader("referer");
    }




}
