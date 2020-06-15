package kostuchenkov.rgr.model.repository.specifications;

import kostuchenkov.rgr.model.domain.product.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProductFilterSpecifications {

    public static Specification<Product> matchPrice(Integer min, Integer max) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {

            if(min != null && max != null) {
                return criteriaBuilder.between(root.get("price"), min, max);
            }
            else if(min != null) {
                return criteriaBuilder.greaterThan(root.get("price"), min);
            }
            else if(max != null) {
                return criteriaBuilder.lessThan(root.get("price"), max);
            }
            return null;
        };
    }

    public static Specification<Product> inSubcategories(List<ProductSubcategory> subcategories) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            if(!subcategories.isEmpty()) {
                return root.get("subcategory").in(subcategories);
            }
            return null;
        };
    }

    public static Specification<Product> inSeasons(List<ProductSeason> seasons) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            if(!seasons.isEmpty()) {
                return root.get("season").in(seasons);
            }
            return null;
        };
    }

    public static Specification<Product> inBrands(List<ProductBrand> brands) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            if(!brands.isEmpty()) {
                return root.get("brand").in(brands);
            }
            return null;
        };
    }

    public static Specification<Product> inMaterials(List<ProductMaterial> materials) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            if(!materials.isEmpty()) {
                return root.get("material").in(materials);
            }
            return null;
        };
    }

    public static Specification<Product> inCategory(ProductCategory category) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            if(category != null) {
                return criteriaBuilder.equal(root.get("category"), category);
            }
            return null;
        };
    }


}
