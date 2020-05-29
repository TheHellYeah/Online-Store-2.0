package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(ProductCategory category);
}
