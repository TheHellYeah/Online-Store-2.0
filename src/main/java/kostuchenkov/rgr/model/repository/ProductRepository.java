package kostuchenkov.rgr.model.repository;

import kostuchenkov.rgr.model.domain.product.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAll(Pageable pageable);

    List<Product> findByCategory(ProductCategory category);
    List<Product> findByCategoryAndSubcategoryInAndBrandInAndSeasonIn(ProductCategory category,
                                                                      List<ProductSubcategory> subcategories,
                                                                      List<ProductBrand> brands,
                                                                      List<ProductSeason> seasons);
    List<Product> findBySubcategoryInAndBrandInAndSeasonIn(List<ProductSubcategory> subcategories,
                                                           List<ProductBrand> brands,
                                                           List<ProductSeason> seasons);
    List<Product> findByNameContaining(String name);
}
