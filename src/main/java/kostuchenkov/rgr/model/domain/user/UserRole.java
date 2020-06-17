package kostuchenkov.rgr.model.domain.user;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Locale;
import java.util.ResourceBundle;

public enum UserRole implements GrantedAuthority {
    CUSTOMER,
    SELLER,
    ADMIN;

    @Override
    public String toString() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/enum", locale);
        return bundle.getString(this.name());
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
