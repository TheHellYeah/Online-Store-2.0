package kostuchenkov.rgr.web.utils.controller;

import kostuchenkov.rgr.model.domain.product.*;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerUtils {

    //Чтобы в контроллерах по тысяче раз не писать одно и то же, кидаем в модель все текущие значения для всех енамов продукта
    public static void putEnumsIntoModel(Model model) {
        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
    }

    public static void putErrorsIntoModel(Model model, BindingResult bindingResult) {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/messages",locale);

        Map<String, String> errors = new HashMap<>();
                                    //Мы так делаем потому что бандл нельзя вставить в сообщения аннотаций(они требуют константы),
                                    //поэтому в мессадже находится ключ к локали в i18n бандле
        bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField() + "Error", bundle.getString(e.getDefaultMessage())));
        model.mergeAttributes(errors);
    }
}
