package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.web.utils.ControllerUtils;
import kostuchenkov.rgr.web.utils.filter.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }

    @GetMapping("/")
    public String indexPage(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, value = 12) Pageable pageable,
                            ProductFilter filter,
                            String searchQuery,
                            Model model) {

        Page<Product> products;

        if(!filter.isEmpty()) {
            model.addAttribute("filters", filter.getFilters());
            products = productService.getAllProductsByFilter(filter, pageable);
        }
        else if(searchQuery != null && !searchQuery.equals("")) {
            products = productService.searchProductsPage(searchQuery, pageable);
            model.addAttribute("searchQuery", searchQuery);
        }
        else {
            products = productService.getAllProducts(pageable);
        }

        model.addAttribute("products", products);
        ControllerUtils.putEnumsIntoModel(model);
        return "index";
    }

    @ResponseBody
    @PostMapping("/")
    public List<Product> search(@RequestParam String name) {
        return productService.searchProductsList(name);
    }
}
