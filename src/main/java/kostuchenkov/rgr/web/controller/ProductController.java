package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.web.utils.validation.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;

@Controller
public class ProductController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id:\\d+}")
    public String productPage(@PathVariable("id") Product product, Model model) {
        if(product != null) {
            model.addAttribute("product", product);
            model.addAttribute("reviews", product.getReviews());
            model.addAttribute("sizes", new TreeMap<>(product.getSizes()));
        }
        return "product";
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('SELLER')")
    @GetMapping("/product/add")
    public String page(Model model) {

        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        return "add-product-form";
    }

    @PostMapping("/product/add")
    public String addProduct(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Model model)  {

        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField() + "Error", e.getDefaultMessage()));
            model.mergeAttributes(errors); //TODO доделать отображение ошибок в view

            model.addAttribute("subcategories", ProductSubcategory.values());
            model.addAttribute("categories", ProductCategory.values());
            model.addAttribute("brands", ProductBrand.values());
            model.addAttribute("seasons", ProductSeason.values());
            model.addAttribute("materials", ProductMaterial.values());
            return "add-product-form";
        }
        productService.addProductFromForm(productForm);
        return "redirect:/";
    }
}
