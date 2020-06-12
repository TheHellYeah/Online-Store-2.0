package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.web.utils.controller.ControllerUtils;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationForm;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRegistrationFormValidator validator;


    //TODO валидатор который проверяет уникальность логина и емейла юзера,вывод ошибок еще не сделан
    @InitBinder("userRegistrationForm")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        return "form-registration";
    }

    @PostMapping("/registration")
    public String register(@Valid UserRegistrationForm userForm, BindingResult bindingResult, Model model) throws Exception {

        if(bindingResult.hasErrors()) {
            ControllerUtils.putErrorsIntoModel(model, bindingResult);
            return "form-registration";
        }
        userService.registerFromUserForm(userForm);
        model.addAttribute("message", "Успех! Проверьте указанный почтовый ящик и перейдите по ссылке в письме для завершения регистрации");
        return "redirect:/login";
    }

    @GetMapping("/activate")
    public String activateCode(Model model, @RequestParam(required = false) String code) {
        if (code==null){
            return "activate";
        }else {
            if ( userService.verifyUser(code)){
                return "redirect:/login";
            }else {//TODO сообщение об ошибке
                return "activate";
            }

        }
    }
}

