package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.model.user.User;
import kostuchenkov.rgr.data.repository.UserRepository;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@Valid UserRegistrationForm userForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField() + "Error", e.getDefaultMessage()));
            model.mergeAttributes(errors); //TODO доделать отображение ошибок в view
            return "registration";
        }

        userService.registerFromUserForm(userForm);
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {

        boolean isVerified = userService.verifyUser(code);
        if (isVerified) {
            model.addAttribute("message", "Ваш аккаунт успешно активирован.\nМожете авторизороваться.");
        } else {
            model.addAttribute("message", "Что то пошло не так.\n  Попробуйте снова позже.");
        }
        return "login";
    }
}

