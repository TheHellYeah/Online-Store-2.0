package kostuchenkov.rgr.model.service.user;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.domain.user.UserWishListAccess;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.model.service.mail.MailService;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService  {

    void registerFromUserForm(UserRegistrationForm userForm);

    boolean verifyUser(String code);

    List<User> getAllUsers();

    User getUserById(int id);

    List<User> getAllUsersByRole(UserRole role);

    void dismiss(User user);

    void appoint(User user);

    boolean isUserExistsWithEmail(String email);

    boolean isUserExistsWithUsername(String username);

    void changeProfileSettings(User user, MultipartFile avatar, UserWishListAccess access);

    boolean editBalance(User user, Integer balance);
}
