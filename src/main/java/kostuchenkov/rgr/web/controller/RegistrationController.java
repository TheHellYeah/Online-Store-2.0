package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.MailService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    MailService mailService;

    @GetMapping("/registration")
    public String registrationPage() {

        return "registration";
    }

    @PostMapping("/registration")
    public String register(User user, Model model) {

        userService.register(user);
        model.addAttribute("message","На вашу почту отправлено письмо.\n Перейдите по ссылке в письме, \n что бы активировать ваш аккаунт");
        return "registration";
    }


    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isVerified = userService.verifyUser(code);
        if (isVerified) {
            model.addAttribute("message",  "Ваш аккаунт успешно активирован.\nМожете авторизороваться.");
        }else {
            model.addAttribute("message", "Что то пошло не так.\n  Попробуйте снова позже.");
        }
        return "/login";
    }
}

