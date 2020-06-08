package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.model.repository.ProductRepository;
import kostuchenkov.rgr.web.utils.validation.ProductForm;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${upload.path}")
    private String uploadPath;
    @Value("${product.image.default}")
    private String defaultImagePath;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> getAllProductsInCategory(ProductCategory category) {
        return productRepository.findByCategory(category);
    }

    public Optional<Product> getProductById(String productId) {
        try {
            int id = Integer.parseInt(productId);
            return productRepository.findById(id);
        } catch(NumberFormatException e) {
            return Optional.empty();
        }
    }

    public void addProductFromForm(ProductForm productForm) {

        Product product = new Product();
        BeanUtils.copyProperties(productForm, product);

        saveProductImages(productForm.getImages(), product);
        product.getSizes().putAll(getSizeMapFromForm(productForm));

        productRepository.save(product);
    }

    public List<Product> getProductsByFilter(ProductCategory category, List<ProductSubcategory> subcategories,
                                             List<ProductBrand> brands, List<ProductSeason> seasons) {
        if(subcategories == null) {
            subcategories = Arrays.asList(ProductSubcategory.values());
        }
        if(brands == null) {
            brands = Arrays.asList(ProductBrand.values());
        }
        if(seasons == null) {
            seasons = Arrays.asList(ProductSeason.values());
        }
        if(category == null) {
            return productRepository.findBySubcategoryInAndBrandInAndSeasonIn(subcategories, brands, seasons);
        } else {
            return productRepository.findByCategoryAndSubcategoryInAndBrandInAndSeasonIn(category, subcategories, brands, seasons);
        }
    }

    public List<Product> getProductsContainingString(String name) {
        return productRepository.findByNameContaining(name);
    }

    public void update(Product product){
        productRepository.save(product);
    }

    private void saveProductImages(List<MultipartFile> files, Product product) {

        if (files != null && !files.get(0).isEmpty()) { //Лист файлов в контроллер приходит
                                                        // почему то с одним итемом с названием "", поэтому еще проверка
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            for (MultipartFile file : files) {
                String resultFileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename();
                 try {
                     file.transferTo(new File(uploadPath + "/" + resultFileName));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                product.getImages().add(resultFileName);
            }
        } else {
            product.getImages().add(defaultImagePath);
        }
    }

    private Map<ProductSize, Integer> getSizeMapFromForm(ProductForm form) {
        Map<ProductSize, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i < form.getSizes().size(); i++) {
            sizeMap.put(form.getSizes().get(i), form.getAmount().get(i));
        }
        return sizeMap;
    }
}
