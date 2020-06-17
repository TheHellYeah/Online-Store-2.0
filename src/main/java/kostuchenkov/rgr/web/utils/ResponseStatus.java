package kostuchenkov.rgr.web.utils;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResponseStatus {
    CART_ADD,
    CART_CLEAR,
    CART_DELETE,
    WISH_ADD,
    CART_ERROR,
    SUCCESS,
    ERROR,
    WISH_ERROR;


    @Override
    public String toString() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/enum", locale);
        return bundle.getString(this.name());
    }

}
