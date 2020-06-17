package kostuchenkov.rgr.web.utils;

import kostuchenkov.rgr.model.domain.product.*;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerUtils {

    public static void putEnumsIntoModel(Model model) {
        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
        model.addAttribute("sizes", ProductSize.values());
    }

    public static void putErrorsIntoModel(Model model, BindingResult bindingResult) {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/messages",locale);

        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField() + "Error", bundle.getString(e.getDefaultMessage())));
        model.mergeAttributes(errors);
    }
}
