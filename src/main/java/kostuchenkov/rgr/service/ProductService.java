package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.product.*;
import kostuchenkov.rgr.model.repository.ProductRepository;
import kostuchenkov.rgr.web.utils.filter.ProductFilter;
import kostuchenkov.rgr.web.utils.validation.ProductForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<Product> getAllProductsContainingString(String name) {
        return productRepository.findByNameContaining(name);
    }

    public Page<Product> getProductsContainingString(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    public List<Product> getAllProductsInCategory(ProductCategory category) {
        return productRepository.findByCategory(category);
    }

    public Optional<Product> getProductById(String productId) {
        try {
            int id = Integer.parseInt(productId);
            return productRepository.findById(id);
        } catch (NumberFormatException e) {
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

    public void update(Product product) {
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

    public Page<Product> getAllProductsByFilter(ProductFilter filter, Pageable pageable) {

        if (filter.getSubcategory().isEmpty()) {
            filter.setSubcategory(Arrays.asList(ProductSubcategory.values()));
        }
        if (filter.getBrand().isEmpty()) {
            filter.setBrand(Arrays.asList(ProductBrand.values()));
        }
        if (filter.getSeason().isEmpty()) {
            filter.setSeason(Arrays.asList(ProductSeason.values()));
        }
        if (filter.getMaterial().isEmpty()) {
            filter.setMaterial(Arrays.asList(ProductMaterial.values()));
        }
        if (filter.getSearchQuery() != null) {
            return productRepository.findByNameContainingAndSubcategoryInAndSeasonInAndMaterialInAndBrandIn
                    (filter.getSearchQuery(), filter.getSubcategory(), filter.getSeason(), filter.getMaterial(), filter.getBrand(), pageable);
        } else {
            return productRepository.findBySubcategoryInAndSeasonInAndMaterialInAndBrandIn
                    (filter.getSubcategory(), filter.getSeason(), filter.getMaterial(), filter.getBrand(), pageable);
        }
    }

    public Page<Product> getProductsFilteredByPrice(Integer min, Integer max) {
        if(min != null && max != null) {

        } else if(min == null) {

        } else {

        }
    }
}
