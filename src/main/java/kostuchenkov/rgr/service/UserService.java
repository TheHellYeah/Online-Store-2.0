package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.domain.user.UserRole;
import kostuchenkov.rgr.data.repository.UserRepository;
import kostuchenkov.rgr.service.validation.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailService mailService;

    public void register(User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Здравствуйте, %s %s ! \n" +
                            "Перейдите по ссылке для активации вашего аккаунта :\n" +
                            "http://localhost:8080/activate/%s",user.getFirstName(), user.getSecondName(), user.getActivationCode()
            );

            mailService.send(user.getEmail(),"Код активации",message);
        }
    }

    public void saveUser(User user){
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

    public boolean verifyUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null){
            return false;
        }

        user.setActivationCode(null);
        user.setVerified(true);
        userRepository.save(user);
        return true;


    }
}
