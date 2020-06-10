package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.web.utils.filter.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                            Model model) {

        Page<Product> products;
        if(filter.isEmpty() && filter.getSearchQuery() == null) {
            products = productService.getAllProducts(pageable);
        } else {
            if(!filter.isEmpty()) {
                model.addAttribute("filters", filter.getFilters());
            }
            if(filter.getSearchQuery() != null) {
                model.addAttribute("searchQuery", filter.getSearchQuery());
            }
            products = productService.getAllProductsByFilter(filter, pageable);
        }

        model.addAttribute("products", products);
        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        return "index";
    }

    @ResponseBody
    @PostMapping("/")
    public List<Product> search(@RequestParam String name) {
        return productService.getAllProductsContainingString(name);
    }
}
