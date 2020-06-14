package kostuchenkov.rgr.mocks;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.service.principal.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.HashSet;

public class WithMockAdminSecurityContextFactory implements WithSecurityContextFactory<WithMockAdmin> {

    @Override
    public SecurityContext createSecurityContext(WithMockAdmin withMockAdmin) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        User user = new User();
        user.setUsername(withMockAdmin.username());
        user.setPassword(withMockAdmin.password());
        user.setId(withMockAdmin.id());
        user.setRoles(new HashSet<>());
        user.getRoles().add(withMockAdmin.role());

        UserDetailsImpl principal = new UserDetailsImpl(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", user.getRoles());
        context.setAuthentication(auth);
        return context;
    }
}
