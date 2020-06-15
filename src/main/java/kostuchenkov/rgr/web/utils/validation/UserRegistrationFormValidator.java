package kostuchenkov.rgr.web.utils.validation;

import kostuchenkov.rgr.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserRegistrationForm userForm = (UserRegistrationForm)o;

        if(userService.isUserExistsWithEmail(userForm.getEmail())) {
            errors.rejectValue("email", "userExistsLogin", "registration.email.exists");
        }
        if(userService.isUserExistsWithUsername(userForm.getUsername())) {
            errors.rejectValue("username", "userExistsEmail", "registration.username.exists");
        }
    }
}
