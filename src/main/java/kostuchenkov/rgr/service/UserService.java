package kostuchenkov.rgr.service;

import kostuchenkov.rgr.domain.user.User;
import kostuchenkov.rgr.domain.user.UserStatus;
import kostuchenkov.rgr.repository.UserRepository;
import kostuchenkov.rgr.service.validation.UserRegistrationForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    public void addUserFromRegistrationForm(UserRegistrationForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        //FIXME шифрование пароля
        //user.setPassword();
        user.setStatus(UserStatus.CUSTOMER);

        userRepository.save(user);
    }
}
