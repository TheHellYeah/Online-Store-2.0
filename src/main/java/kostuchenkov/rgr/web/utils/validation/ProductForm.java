package kostuchenkov.rgr.web.utils.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

//TODO
@Getter
@Setter
public class ProductForm {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private int price;
}
