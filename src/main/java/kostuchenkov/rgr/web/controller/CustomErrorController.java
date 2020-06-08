package kostuchenkov.rgr.web.controller;

import lombok.val;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String errorPage(HttpServletRequest request, Model model) {

        val status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null) {
            int statusCode = Integer.parseInt(status.toString());
            //TODO я добавил только два статус кода пока что, не помню какие там еще у нас могут вылететь, если что по аналогии добавишь сам
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("error", "Запрашиваемая вами страница не найдена!");
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("error", "У вас недостаточно прав для просмотора запрашиваемой страницы!");
            }
            else if(statusCode == HttpStatus.BAD_REQUEST.value()) {
                model.addAttribute("error", "Ошибка сервера!");
            }
            else {
                model.addAttribute("error", "Ошибка!");
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
