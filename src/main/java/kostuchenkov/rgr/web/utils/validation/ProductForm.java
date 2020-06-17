package kostuchenkov.rgr.web.utils.validation;

import kostuchenkov.rgr.model.domain.product.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Getter
@Setter
public class ProductForm {

    @NotBlank(message = "validation.blank")
    @Size(min = 5, message = "validation.min5")
    @Size(max = 20, message = "validation.max20")
    private String name;

    @Size(max = 2048, message = "validation.max255")
    private String description;

    @NotNull(message = "product.price.null")
    @Positive(message = "product.price.positive")
    private Integer price;

    @NotNull(message = "product.null")
    private ProductCategory category;

    @NotNull(message = "product.null")
    private ProductSubcategory subcategory;

    @NotNull(message = "product.null")
    private ProductBrand brand;

    @NotNull(message = "product.null")
    private ProductMaterial material;

    @NotNull(message = "product.null")
    private ProductSeason season;

    private List<MultipartFile> images = new ArrayList<>();

    @NotEmpty(message = "product.size.null")
    private List<ProductSize> sizes = new ArrayList<>();
    private List<Integer> amount = new ArrayList<>();

    public void setPrice(String price) {
        try {
            this.price = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            this.price = null;
        }
    }
}
