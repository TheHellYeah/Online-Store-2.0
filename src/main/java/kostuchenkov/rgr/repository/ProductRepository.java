package kostuchenkov.rgr.repository;

import kostuchenkov.rgr.domain.product.Product;
import kostuchenkov.rgr.domain.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findByCategory(ProductCategory category);
}
