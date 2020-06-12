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

    @NotBlank(message = "checkout.blank")
    @Size(max = 20, message = "checkout.max20")
    private String firstName;

    @NotBlank(message = "checkout.blank")
    @Size(max = 20, message = "checkout.max20")
    private String secondName;

    @Size(max = 20, message = "checkout.max20")
    private String patronymic;

    @NotBlank
    private String phone;

    @NotBlank(message = "checkout.blank")
    private String address;

    @NotNull(message = "checkout.null")
    private OrderPayment payment;

    public String getContact() {
        return firstName + secondName + patronymic;
    }
}
