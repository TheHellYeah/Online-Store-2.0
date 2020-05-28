package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findByCategory(ProductCategory category);
}
