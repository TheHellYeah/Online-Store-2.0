package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.model.product.*;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
public class AddProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/product/add")
    public String page(Model model) {

        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        return "add-product-form";
    }

    //FIXME валидация продукта(желательно в сервисе)
    @PostMapping("/product/add")
    public String addProduct(
            Product product,
            @RequestParam("size") List<ProductSize> size,
            @RequestParam("count") List<Integer> count,
            @RequestParam("files") List<MultipartFile> files) throws IOException {

        if (files != null) {                         // настройки пути сохраннения в пропертис
            File uploadDir = new File(uploadPath);// проверям если ли папка img в хранилище. если нет, то создаем
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            for (MultipartFile file : files) {   // Достаем из запроса файлы, фотки  добавляем им рандомные цифры и саве
                String resultFileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                product.getImages().add(resultFileName);
            }                                   // потом сделаю для каждого товара папку, тип один товар и у него все фотки в одной папке
        }

        Map<ProductSize, Integer> s = new HashMap<>();
        System.out.println(size.toString());
        for (int i = 0; i < size.size(); i++) {
            s.put(size.get(i), count.get(i));
        }
        product.getSizes().putAll(s);
        productService.addProduct(product);

        return "redirect:/";
    }
}
