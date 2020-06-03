package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.product.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

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
