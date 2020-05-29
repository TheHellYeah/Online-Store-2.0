package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductCategory;
import kostuchenkov.rgr.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
