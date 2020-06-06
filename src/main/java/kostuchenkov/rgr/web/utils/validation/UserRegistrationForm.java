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

    @NotEmpty(message = "Заполните это поле")
    @Size(min = 8, message = "Минимальная длина логина - 8 символов")
    @Size(max = 20, message = "Максимальная длина логина - 20 символов")
    private String username;

    @NotBlank(message = "Заполните это поле")
    @Size(min = 8, message = "Минимальная длина пароля - 8 символов")
    @Size(max = 20, message = "Максимальная длина пароля - 20 символов")
    private String password;

    @NotNull(message = "Пароли должны совпадать")
    private String passwordConfirmation;

    @Email(message = "Некорректный адрес электронной почты")
    @NotBlank(message = "Заполните это поле")
    private String email;

    @NotBlank(message = "Заполните это поле")
    @Size(max = 20, message = "Максимальная длина поля - 20 символов")
    private String firstName;

    @NotBlank(message = "Заполните это поле")
    @Size(max = 20, message = "Максимальная длина поля - 20 символов")
    private String secondName;

    @Size(max = 20, message = "Максимальная длина поля - 20 символов")
    private String patronymic;

    @NotNull(message = "Введите корректную дату")
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
        } catch (ParseException e) {
            this.birthday = null;
        }
    }
}
