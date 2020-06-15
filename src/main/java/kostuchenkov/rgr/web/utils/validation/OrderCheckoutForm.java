package kostuchenkov.rgr.web.utils.validation;

import kostuchenkov.rgr.model.domain.order.OrderPayment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderCheckoutForm {

    @NotBlank(message = "validation.blank")
    @Size(max = 20, message = "validation.max20")
    private String firstName;

    @NotBlank(message = "validation.blank")
    @Size(max = 20, message = "validation.max20")
    private String secondName;

    @Size(max = 20, message = "validation.max20")
    private String patronymic;

    @NotBlank(message = "validation.blank")
    private String phone;

    @NotBlank(message = "validation.blank")
    private String address;

    @NotNull(message = "product.null")
    private OrderPayment orderPayment;

    public String getContact() {
        return firstName + " " + secondName + " " + patronymic;
    }
}
