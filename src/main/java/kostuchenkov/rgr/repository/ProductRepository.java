package kostuchenkov.rgr.repository;

import kostuchenkov.rgr.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
