package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.web.utils.validation.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model, UserForm userForm) {
        model.addAttribute("userForm", userForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String register(Model model, @Valid User user, BindingResult bindingResult) {

        //FIXME
        userService.add(user);
        return "registration";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isVerified = userService.verifyUser(code);
        if (isVerified) {
            model.addAttribute("message", "Ваш аккаунт успешно активирован.\nМожете авторизороваться.");
        } else {
            model.addAttribute("message", "Что то пошло не так.\n  Попробуйте снова позже.");
        }
        return "/login";
    }
}

