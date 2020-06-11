package kostuchenkov.rgr.web.utils.controller;

import kostuchenkov.rgr.model.domain.product.*;
import org.springframework.ui.Model;

public class ControllerUtils {

    //Чтобы в контроллерах по тысяче раз не писать одно и то же, кидаем в модель все текущие значения для всех енамов продукта
    public static void putEnumsIntoModel(Model model) {
        model.addAttribute("subcategories", ProductSubcategory.values());
        model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("brands", ProductBrand.values());
        model.addAttribute("seasons", ProductSeason.values());
        model.addAttribute("materials", ProductMaterial.values());
    }
}
