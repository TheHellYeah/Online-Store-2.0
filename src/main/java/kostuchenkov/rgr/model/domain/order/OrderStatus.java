package kostuchenkov.rgr.model.domain.order;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

public enum OrderStatus {
    DELIVERED,
    IN_TRANSIT,
    PENDING;

    @Override
    public String toString() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/enum", locale);
        return bundle.getString(this.name());
    }
}
