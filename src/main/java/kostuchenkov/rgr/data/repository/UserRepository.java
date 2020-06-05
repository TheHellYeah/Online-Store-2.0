package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.model.user.User;
import kostuchenkov.rgr.data.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByActivationCode(String code);
    List<User> findByRoles(UserRole role);
}
