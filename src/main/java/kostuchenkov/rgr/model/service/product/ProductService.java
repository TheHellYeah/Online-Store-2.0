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

public interface ProductService {

    List<Product> getAllProducts();

    Page<Product> getAllProducts(Pageable pageable);

    List<Product> searchProductsList(String name);

    Page<Product> searchProductsPage(String search, Pageable pageable);

    Optional<Product> getProductById(String productId);

    void addProductFromForm(ProductForm productForm);

    void update(Product product);

    boolean editName(Product product, String newName);

    boolean editPrice(Product product, Integer newPrice);

    Page<Product> getAllProductsByFilter(ProductFilter filter, Pageable pageable);
}
