package kostuchenkov.rgr.model.repository;

import kostuchenkov.rgr.model.domain.product.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    //Pageable запросы нужны, когда мы просто заходим на индекс страницу, или нажимаем в форме поиска кнопку искать
    //тогда нам вовзращаются страницы с продуктами
    Page<Product> findByNameContaining(String name, Pageable pageable);

    //List используем для POST метода, когда мы вбиваем запрос в поисковую строку чтобы вернуть список товаров найденных
    List<Product> findByNameContaining(String name);

    List<Product> findByCategory(ProductCategory category);
}
