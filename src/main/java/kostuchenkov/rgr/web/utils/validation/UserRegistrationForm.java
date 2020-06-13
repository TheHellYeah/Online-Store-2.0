package kostuchenkov.rgr.web.utils.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationForm {

    @NotBlank(message = "validation.blank")
    @Size(min = 8, message = "validation.less8")
    @Size(max = 20, message = "validation.max20")
    private String username;

    @NotBlank(message = "validation.blank")
    @Size(min = 8, message = "validation.less8")
    @Size(max = 20, message = "validation.max20")
    private String password;

    @NotNull(message = "registration.password.null")
    private String passwordConfirmation;

    @Email(message = "registration.email")
    @NotBlank(message = "validation.blank")
    private String email;

    @NotBlank(message = "validation.blank")
    @Size(max = 20, message = "validation.max20")
    private String firstName;

    @NotBlank(message = "validation.blank")
    @Size(max = 20, message = "validation.max20")
    private String secondName;

    @Size(max = 20, message = "validation.max20")
    private String patronymic;

    @NotNull(message = "registration.date")
    private Date birthday;

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
        if (!this.passwordConfirmation.equals(password)) {
            this.passwordConfirmation = null;
        }
    }

    public void setBirthday(String birthday)  {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
            this.birthday = formatter.parse(birthday);
            if(this.birthday.after(new Date())) {
                this.birthday = null;
            }
        } catch (ParseException e) {
            this.birthday = null;
        }
    }
}
