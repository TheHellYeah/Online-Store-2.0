package kostuchenkov.rgr.model.service.product;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.repository.ProductRepository;
import kostuchenkov.rgr.web.utils.filter.ProductFilter;
import kostuchenkov.rgr.web.utils.validation.ProductForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static kostuchenkov.rgr.model.repository.specifications.ProductFilterSpecifications.*;
import static kostuchenkov.rgr.model.repository.specifications.ProductFilterSpecifications.inCategory;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${upload.path}")
    private String uploadPath;
    @Value("${product.image.default}")
    private String defaultImagePath;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> searchProductsList(String name) {
        return productRepository.findByNameContaining(name);
    }

    @Override
    public Page<Product> searchProductsPage(String search, Pageable pageable) {
        return productRepository.findByNameContaining(search, pageable);
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        try {
            int id = Integer.parseInt(productId);
            return productRepository.findById(id);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public void addProductFromForm(ProductForm productForm) {

        Product product = new Product();
        BeanUtils.copyProperties(productForm, product);

        saveProductImages(productForm.getImages(), product);
        product.getSizes().putAll(getSizeMapFromForm(productForm));

        productRepository.save(product);
    }

    @Override
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

    @Override
    public boolean editName(Product product, String newName){
        product.setName(newName);
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean editPrice(Product product, Integer newPrice){
        product.setPrice(newPrice);
        productRepository.save(product);
        return true;
    }


    @Override
    public Page<Product> getAllProductsByFilter(ProductFilter filter, Pageable pageable) {

        if(filter.isSorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.Direction.valueOf(filter.getSortOrder()), filter.getSortBy());

        }
        return productRepository.findAll(matchPrice(filter.getMinPrice(), filter.getMaxPrice())
                        .and(inSubcategories(filter.getSubcategory()))
                        .and(inBrands(filter.getBrand()))
                        .and(inMaterials(filter.getMaterial()))
                        .and(inSeasons(filter.getSeason()))
                        .and(inCategory(filter.getCategory()))
                        .and(bySizes(filter.getSize()))
                         ,pageable);
    }
}
