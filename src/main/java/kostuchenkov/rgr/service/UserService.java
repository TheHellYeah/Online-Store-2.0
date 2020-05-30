package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.domain.user.UserRole;
import kostuchenkov.rgr.data.repository.UserRepository;
import kostuchenkov.rgr.service.validation.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        user.setRoles(Collections.singleton(UserRole.CUSTOMER));
        userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    //TODO валидацию доделать или забить хуй
    public void addUserFromRegistrationForm(UserRegistrationForm userForm) {
//        User user = new User();
//        BeanUtils.copyProperties(userForm, user);
//        //FIXME шифрование пароля
//        //user.setPassword();
//        user.setStatus(UserRole.CUSTOMER);
//
//        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
