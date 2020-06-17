package kostuchenkov.rgr.model.domain.product;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ProductSeason {
    SUMMER,
    AUTUMN,
    WINTER,
    SPRING;

    @Override
    public String toString() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/enum",locale);
        return bundle.getString(this.name());
    }
}
