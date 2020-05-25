package kostuchenkov.rgr.controller;

import kostuchenkov.rgr.domain.user.User;
import kostuchenkov.rgr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

//    @PostMapping("/registration")
//    public String register(String username, String password, String firstName, String secondName, String patronymic, String email, String birthday, Model model) {
//        //User user = userRepository.findByUsername(username);
//        if(user != null) {
//
//            model.addAttribute("alert", "Пользователь с данным логином уже существует");
//            return "registration";  //FIXME пользователь с таким логином или емайлом уже существует
//        }
//        else {
//            user = new User();
//            user.setStatus(UserStatus.CUSTOMER);
//            userRepository.save(user);
//            model.addAttribute("alert", "Неверный логин или пароль");
//            return "login";
//        }
//    }
}
