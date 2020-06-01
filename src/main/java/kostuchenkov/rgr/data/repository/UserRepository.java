package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);

    User findByActivationCode(String code);
}
