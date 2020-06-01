package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.service.MailService;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

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

        user.setActivationCode(UUID.randomUUID().toString());
        userService.addUser(user);

        if (!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Здравствуйте, %s %s ! \n" +
                    "Перейдите по ссылке для активации вашего аккаунта :\n" +
                            "http://localhost:8080/activate/%s",user.getFirstName(), user.getSecondName(), user.getActivationCode()
            );

            mailService.send(user.getEmail(),"Код активации",message);
        }
        //model.addAttribute("message","На вашу почту отправлено письмо.\n Перейдите по ссылке в письме, \n что бы активировать ваш аккаунт");
        return "redirect:/login";
    }


    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isVerifed = userService.verifUser(code);
        if (isVerifed) {
            model.addAttribute("message",  "Ваш аккаунт успешно активирован.\nМожете авторизороваться.");
        }else {
            model.addAttribute("message", "Что то пошло не так.\n  Попробуйте снова позже.");
        }
        return "/login";
    }
}

