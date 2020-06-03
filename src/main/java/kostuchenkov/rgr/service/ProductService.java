package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.product.*;
import kostuchenkov.rgr.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
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

    public void addProduct(Product product) {
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
}
