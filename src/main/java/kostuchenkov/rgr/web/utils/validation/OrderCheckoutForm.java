package kostuchenkov.rgr.web.utils.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class OrderCheckoutForm {

    @NotBlank
    @Size(max = 20, message = "Максимальная длина поля - 20 символов")
    private String firstName;

    @NotBlank
    @Size(max = 20, message = "Максимальная длина поля - 20 символов")
    private String secondName;
    @Size(max = 20, message = "Максимальная длина поля - 20 символов")
    private String patronymic;

    private String phone;

    @NotBlank
    private String address;
}
