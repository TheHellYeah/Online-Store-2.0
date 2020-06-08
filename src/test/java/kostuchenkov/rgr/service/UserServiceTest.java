package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationForm;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private MailService mailService;
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void registerFromUserForm() {

        UserRegistrationForm userForm = new UserRegistrationForm();


    }

    @Test
    void userExistenceTest() throws Exception {

        User user = new User();
        user.setUsername("Artem");
        user.setEmail("Mail");

        Mockito.doReturn(user).when(userRepository).findByUsername("Artem");
        Mockito.doReturn(user).when(userRepository).findByEmail("Mail");

        boolean userExistsWithUsername = userService.isUserExistsWithUsername("Artem");
        boolean userExistsWithEmail = userService.isUserExistsWithEmail("Mail");
        boolean userDoesNotExistsWithEmail = userService.isUserExistsWithEmail("FakeMail");

        Assert.assertTrue(userExistsWithEmail);
        Assert.assertTrue(userExistsWithUsername);
        Assert.assertFalse(userDoesNotExistsWithEmail);
    }

    @Test
    void changeUserRole() {
        User user = new User();
        user.setRoles(Collections.singleton(UserRole.SELLER));

        userService.dismiss(user);
        Assert.assertFalse(user.isSeller());
        userService.appoint(user);
        Assert.assertTrue(user.isSeller());
    }

    @Test
    void verifyUser() {
    }

    @Test
    void getAllUsersTest() {

        List<User> users = new ArrayList<>();
        Mockito.doReturn(users).when(userRepository).findAll();

        List<User> expected = userRepository.findAll();
        Assert.assertSame(users, expected);
    }

    @Test
    void getUserById() {
    }

    @Test
    void getAllUsersByRole() {
    }

    @Test
    void dismiss() {
    }

    @Test
    void appoint() {
    }
}