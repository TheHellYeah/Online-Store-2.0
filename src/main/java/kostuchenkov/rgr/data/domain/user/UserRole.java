package kostuchenkov.rgr.data.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    CUSTOMER,
    SELLER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
