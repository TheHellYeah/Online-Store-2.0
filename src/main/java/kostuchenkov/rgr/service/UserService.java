package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.domain.user.UserWishListAccess;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${user.image.default}")
    private String defaultAvatarPath;
    @Value("${upload.path.user}")
    private String userAvatarsFolder;

    public void registerFromUserForm(UserRegistrationForm userForm) throws Exception {

        User user = new User();
        BeanUtils.copyProperties(userForm, user);

        user.setRoles(Collections.singleton(UserRole.CUSTOMER));
        user.setWishListAccess(UserWishListAccess.PUBLIC);
        user.setAvatar(defaultAvatarPath);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        mailService.sendActivationMail(user);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public boolean verifyUser(String code) {

        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        user.setVerified(true);
        userRepository.save(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> getAllUsersByRole(UserRole role) {
        return userRepository.findByRoles(role);
    }

    public void dismiss(User user){
        user.getRoles().remove(UserRole.SELLER);
        userRepository.save(user);
    }

    public void appoint(User user) {
        user.getRoles().add(UserRole.SELLER);
        userRepository.save(user);
    }

    public boolean isUserExistsWithEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean isUserExistsWithUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public void changeProfileSettings(User user, MultipartFile avatar, UserWishListAccess access) {
        if(avatar != null) {
            changeUserAvatar(avatar, user);
        }
        user.setWishListAccess(access);
        userRepository.save(user);
    }

    private void changeUserAvatar(MultipartFile file, User user) {
        String resultFileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename();
        try {
            file.transferTo(new File(userAvatarsFolder + "/" + resultFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setAvatar(resultFileName);
    }
}
