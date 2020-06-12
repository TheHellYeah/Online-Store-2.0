package kostuchenkov.rgr.model.domain.email;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

public enum EmailSubject {
    REGISTRATION,
    CREATE_ORDER,
    CHANGE_STATUS;

    @Override
    public String toString() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/enum", locale);
        return bundle.getString(this.name());
    }
}
