package kostuchenkov.rgr.service.principal;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = -1987177972808846853L;

    private User user;
    private List<GrantedAuthority> roles = new ArrayList<>();

    public UserDetailsImpl(User user) {
        this.user = user;
        for(UserRole role : user.getRoles()) {
            GrantedAuthority auth = new SimpleGrantedAuthority(role.getAuthority());
            roles.add(auth);
        }
    }

    public User getUser() {
        return this.user;
    }

    public int getUserId() {
        return this.user.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isVerified();
    }
}
