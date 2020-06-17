package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.domain.user.UserWishListAccess;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.model.service.mail.MailService;
import kostuchenkov.rgr.model.service.user.UserService;
import kostuchenkov.rgr.web.utils.validation.UserRegistrationForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @MockBean
    private MailService mailService;

    @Test
    public void registerUserTest() throws Exception {
        UserRegistrationForm userForm = new UserRegistrationForm();
        userForm.setPassword("1234");
        userService.registerFromUserForm(userForm);

        Mockito.verify(userRepository, Mockito.times(1)).save(new User());
        Mockito.verify(bCryptPasswordEncoder, Mockito.times(1)).encode("1234");
        Mockito.verify(mailService, Mockito.times(1)).sendActivationMail(new User());
    }

    @Test
    public void userActivationTest() throws Exception {
        User user = new User();
        user.setActivationCode("1");
        Mockito.when(userRepository.findByActivationCode("1")).thenReturn(user);
        Mockito.when(userRepository.findByActivationCode("2")).thenReturn(null);

        Assert.assertTrue(userService.verifyUser("1"));
        Assert.assertFalse(userService.verifyUser("2"));
    }

    @Test
    public void changePrivilegesTest() throws Exception {

        User user = new User();
        user.setRoles(new HashSet<>());
        user.getRoles().add(UserRole.CUSTOMER);

        userService.appoint(user);
        Assert.assertTrue(user.isSeller());

        userService.dismiss(user);
        Assert.assertFalse(user.isSeller());
    }

    @Test
    public void changeSettingsTest() throws Exception {

        User user = new User();
        user.setWishListAccess(UserWishListAccess.PUBLIC);
        MultipartFile avatar = Mockito.mock(MultipartFile.class);
        Mockito.when(avatar.getOriginalFilename()).thenReturn("Avatar");

        //userService.changeProfileSettings(user, avatar, UserWishListAccess.PRIVATE);

        Assert.assertFalse(user.isWishListPublic());
        Assert.assertNotNull(user.getAvatar());
    }

    @Test
    public void editBalanceTest() throws Exception {
        User user = new User();
        user.setBalance(100);

       // userService.editBalance(user, 200);

        Assert.assertEquals(user.getBalance(), 200);
    }
}
