package kostuchenkov.rgr.controller;

import kostuchenkov.rgr.domain.user.User;
import kostuchenkov.rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String authorize(@RequestParam String login, @RequestParam String password, Model model) {
        User user = userService.findByLoginAndPassword(login, password);
        if (user != null) {
            return "";  //FIXME авторизация прошла успешно, нужно вернуть залогиненную страничку
        } else {
            model.addAttribute("alert", "Неверный логин или пароль");
            return "login";
        }
    }
}
