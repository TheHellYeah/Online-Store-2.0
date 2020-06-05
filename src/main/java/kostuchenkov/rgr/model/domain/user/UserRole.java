package kostuchenkov.rgr.model.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    CUSTOMER,
    SELLER,
    ADMIN;

    @Override
    public String toString() {
        if(this.equals(CUSTOMER)) return "Покупатель";
        if(this.equals(SELLER)) return "Продавец";
        else return "Администратор";
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
