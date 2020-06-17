package kostuchenkov.rgr.web.controller;

import freemarker.template.utility.HtmlEscape;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.dto.ProductJsonDTO;
import kostuchenkov.rgr.model.service.product.ProductService;
import kostuchenkov.rgr.web.utils.ControllerUtils;
import kostuchenkov.rgr.web.utils.filter.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getLangDataTable")
    public String locale() {
        if (LocaleContextHolder.getLocale().toString().contains("ru")) {
            return new File("static/dataTables/Russian.json").toString();
        } else {
            return new File("static/dataTables/English.json").toString();
        }
    }

    @GetMapping(value = {"/", "/catalog/{category}"})
    public String indexPage(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, value = 12) Pageable pageable,
                            @PathVariable(value = "category", required = false) String category,
                            ProductFilter filter,
                            String searchQuery,
                            Model model) {

        Page<Product> products;
        //FIXME страница юзера
        //FIXME страница товара
        //FIXME тесты

        if (!filter.isEmpty()) {
            model.addAttribute("filters", filter.getFilters());
            products = productService.getAllProductsByFilter(filter, pageable);
        } else if (searchQuery != null && !searchQuery.equals("")) {
            products = productService.searchProductsPage(searchQuery, pageable);
            model.addAttribute("searchQuery", searchQuery);
        } else {
            products = productService.getAllProducts(pageable);
        }

        model.addAttribute("products", products);
        ControllerUtils.putEnumsIntoModel(model);
        return "index";
    }

    @ResponseBody
    @PostMapping(value = "/")
    public List<ProductJsonDTO> search(@RequestParam String name) {
        return productService.searchProductsList(name);
    }
}
