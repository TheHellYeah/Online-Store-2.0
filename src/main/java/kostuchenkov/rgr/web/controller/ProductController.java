package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.model.service.product.ProductService;
import kostuchenkov.rgr.model.service.user.UserService;
import kostuchenkov.rgr.web.utils.ControllerUtils;
import kostuchenkov.rgr.web.utils.validation.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.*;

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

        ControllerUtils.putEnumsIntoModel(model);
        return "form-add-product";
    }

    @PostMapping("/product/add")
    public String addProduct(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Model model)  {

        if(bindingResult.hasErrors()) {
            ControllerUtils.putErrorsIntoModel(model, bindingResult);
            ControllerUtils.putEnumsIntoModel(model);
            return "form-add-product";
        }
        productService.addProductFromForm(productForm);
        return "redirect:/";
    }
}
