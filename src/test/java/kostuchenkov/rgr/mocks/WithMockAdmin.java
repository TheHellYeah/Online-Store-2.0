package kostuchenkov.rgr.mocks;

import kostuchenkov.rgr.model.domain.user.UserRole;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockAdminSecurityContextFactory.class)
public @interface WithMockAdmin {

    String username() default "admin";
    String password() default "1234";
    int id() default 1;
    UserRole role() default UserRole.ADMIN;
}
