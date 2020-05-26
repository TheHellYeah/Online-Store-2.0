package kostuchenkov.rgr.controller;

import kostuchenkov.rgr.domain.user.User;
import kostuchenkov.rgr.domain.user.UserStatus;
import kostuchenkov.rgr.repository.UserRepository;
import kostuchenkov.rgr.service.UserService;
import kostuchenkov.rgr.service.validation.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model, UserRegistrationForm userForm) {
        model.addAttribute("userForm", userForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("userForm") UserRegistrationForm userForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("userForm", userForm);
            return "registration";
        } else {
            userService.addUserFromRegistrationForm(userForm);
            return "redirect:/";
        }
    }
}
