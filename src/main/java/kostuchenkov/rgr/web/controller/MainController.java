package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String indexPage(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, value = 12) Pageable pageable, Model model) {

        model.addAttribute("products", productService.getAllProducts(pageable));
        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        return "index";
    }

    @GetMapping(value = "/filter")
    public String filter(@RequestParam(required = false) ProductCategory category,
                         @RequestParam(required = false) List<ProductSubcategory> subcategory,
                         @RequestParam(required = false) List<ProductBrand> brand,
                         @RequestParam(required = false) List<ProductMaterial> material,
                         @RequestParam(required = false) Integer minPrice,
                         @RequestParam(required = false) Integer maxPrice,
                         @RequestParam(required = false) List<ProductSeason> season,
                         Model model) {
        //TODO доделать фильтры на цену, размеры хз
        List<Product> products = productService.getProductsByFilter(category, subcategory, brand, season);

        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/search")
    public String searchResult(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.getProductsContainingString(name));
        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        return "index";
    }

    //TODO  РАБОТАЕТ, скрипт поста в search.js, пришлось через xhr, fetch не захотел. В скрипте получаем список объектов по поиску, осталось сделать
    //всплывающие подсказки для поиска

    @ResponseBody
    @PostMapping(value = "/search")
    public List<Product> search(@RequestParam String name) {
        return productService.getProductsContainingString(name);
    }
}
