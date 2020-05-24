package kostuchenkov.rgr.repository;

import kostuchenkov.rgr.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
