package kostuchenkov.rgr.web.utils.filter;

import kostuchenkov.rgr.model.domain.product.ProductBrand;
import kostuchenkov.rgr.model.domain.product.ProductMaterial;
import kostuchenkov.rgr.model.domain.product.ProductSeason;
import kostuchenkov.rgr.model.domain.product.ProductSubcategory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductFilter {

    private Integer minPrice;
    private Integer maxPrice;
    private List<ProductBrand> brand;
    private List<ProductSubcategory> subcategory;
    private List<ProductMaterial> material;
    private List<ProductSeason> season;

    public ProductFilter() {
        this.brand = new ArrayList<>();
        this.subcategory = new ArrayList<>();
        this.material = new ArrayList<>();
        this.season = new ArrayList<>();
    }

    public boolean isEmpty() {
        return brand.isEmpty() && subcategory.isEmpty() && material.isEmpty() && season.isEmpty() && minPrice == null && maxPrice == null;
    }

    public List<String> getFilters() {
        List<String> filters = new ArrayList<>();
        brand.forEach(b -> filters.add(b.toString()));
        subcategory.forEach(s -> filters.add(s.toString()));
        material.forEach(m -> filters.add(m.toString()));
        season.forEach(s -> filters.add(s.toString()));
        return filters;
    }
}
