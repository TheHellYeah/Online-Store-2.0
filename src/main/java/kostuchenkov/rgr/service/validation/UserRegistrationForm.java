package kostuchenkov.rgr.service.validation;

import javax.validation.constraints.*;
import java.util.Date;

public class UserRegistrationForm  {

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    private String passwordConfirmation;

    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String secondName;

    private String patronymic;

    @NotNull
    private String birthday;

    public UserRegistrationForm() {}

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
        if(!this.password.equals(this.passwordConfirmation)) {
            this.passwordConfirmation = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
