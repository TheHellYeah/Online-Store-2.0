package kostuchenkov.rgr.web.utils.filter;

import kostuchenkov.rgr.model.domain.product.ProductBrand;
import kostuchenkov.rgr.model.domain.product.ProductMaterial;
import kostuchenkov.rgr.model.domain.product.ProductSeason;
import kostuchenkov.rgr.model.domain.product.ProductSubcategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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

        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/messages",locale);

        List<String> filters = new ArrayList<>();

        if(minPrice != null) filters.add(bundle.getString("filter.from") +  " " + minPrice.toString() + "₽");
        if(maxPrice != null) filters.add(bundle.getString("filter.to") + " "    + maxPrice.toString() + "₽");

        brand.forEach(b -> filters.add(b.toString()));
        subcategory.forEach(s -> filters.add(s.toString()));
        material.forEach(m -> filters.add(m.toString()));
        season.forEach(s -> filters.add(s.toString()));

        return filters;
    }
}
