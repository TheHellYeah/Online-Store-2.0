package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductCategory;
import kostuchenkov.rgr.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Iterable<Product> findByCategory(ProductCategory category) {
        return productRepository.findByCategory(category);
    }
}
