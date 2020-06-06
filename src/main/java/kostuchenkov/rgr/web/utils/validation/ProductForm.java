package kostuchenkov.rgr.web.utils.validation;

import kostuchenkov.rgr.model.domain.product.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductForm {

    @NotBlank
    @Size(min = 8, max = 30)
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull
    private int price;
    @NotNull
    private ProductCategory category;
    @NotNull
    private ProductSubcategory subcategory;
    @NotNull
    private ProductBrand brand;
    @NotNull
    private ProductMaterial material;
    @NotNull
    private ProductSeason season;

    private List<MultipartFile> images = new ArrayList<>();
    private List<ProductSize> sizes = new ArrayList<>();
    private List<Integer> amount = new ArrayList<>();
}
