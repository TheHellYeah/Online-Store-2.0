package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductSize;
import kostuchenkov.rgr.service.ProductService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class AddProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Value("${upload.path}")
    private String uploadPath;

   //TODO @Secured("hasRole(ROLE_CUSTOMER) or hasRole(ROLE_ADMIN)")
    @GetMapping("/product/add")
    public String page(Model model) {
        return "add-product-form";
    }

    //FIXME валидация продукта(желательно в сервисе)
    @PostMapping("/product/add")
    public String addProduct(
            Product product,
            @RequestParam("SIZE") List<Integer> size,
            @RequestParam("files") List<MultipartFile> files
            ) throws IOException {



        if (files!=null){                         // настройки пути сохраннения в пропертис
            File uploadDir = new File(uploadPath);// проверям если ли папка img в хранилище. если нет, то создаем
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }
            for(MultipartFile file : files ){   // Достаем из запроса файлы, фотки  добавляем им рандомные цифры и саве
                String resultFileName = UUID.randomUUID().toString() +"."+ file.getOriginalFilename() ;
                file.transferTo(new File(uploadPath + "/" +resultFileName));
                product.getImages().add(resultFileName);
            }                                   // потом сделаю для каждого товара папку, тип один товар и у него все фотки в одной папке

        }


        //FIXME КАСТЫЫЫЫЛЬ СРОЧНО ПЕРЕДЕЛАТЬ
        Map<ProductSize, Integer> s = new HashMap<>();
        for(int i = 0; i< ProductSize.values().length;i++){
            s.put(ProductSize.values()[i],size.get(i));
        }
        product.getSizes().putAll(s);
        productService.addProduct(product);

        return "redirect:/";
    }
}
