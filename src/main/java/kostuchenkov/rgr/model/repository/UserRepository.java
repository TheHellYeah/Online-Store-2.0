package kostuchenkov.rgr.model.repository;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByActivationCode(String code);
    User findByEmail(String email);

    List<User> findByRoles(UserRole role);
}
