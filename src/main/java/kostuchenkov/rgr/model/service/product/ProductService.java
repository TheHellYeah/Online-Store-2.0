package kostuchenkov.rgr.model.service.product;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.dto.ProductJsonDTO;
import kostuchenkov.rgr.web.utils.filter.ProductFilter;
import kostuchenkov.rgr.web.utils.validation.ProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface ProductService {

    List<Product> getAllProducts();

    Page<Product> getAllProducts(Pageable pageable);

    List<ProductJsonDTO> searchProductsList(String name);

    Page<Product> searchProductsPage(String search, Pageable pageable);

    Optional<Product> getProductById(String productId);

    void addProductFromForm(ProductForm productForm);

    void update(Product product);

    boolean editName(Product product, String newName);

    boolean editPrice(Product product, Integer newPrice);

    Page<Product> getAllProductsByFilter(ProductFilter filter, Pageable pageable);
}
