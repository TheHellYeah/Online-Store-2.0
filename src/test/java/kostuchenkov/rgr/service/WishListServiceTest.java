package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.model.service.wishList.WishListService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void addToWishListTest() throws Exception {
        User user = new User();
        Product product = new Product();
        Product product1 = new Product();
        product.setId(1);
        product1.setId(2);
        user.setWishList(new ArrayList<>());
        user.getWishList().add(product);

        boolean isNotAdded = wishListService.addToWishList(user, product);
        Assert.assertFalse(isNotAdded);
        Mockito.verify(userRepository, Mockito.times(0)).save(user);

        boolean isAdded = wishListService.addToWishList(user, product1);
        Assert.assertTrue(isAdded);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void clearWishListTest() throws Exception {
        User user = new User();
        user.setWishList(new ArrayList<>());
        user.getWishList().add(new Product());

        wishListService.clearWishList(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Assert.assertEquals(0, user.getWishList().size());
    }

    @Test
    void deleteFromWishListTest() throws Exception {
        User user = new User();
        user.setWishList(new ArrayList<>());
        Product product = new Product();
        product.setId(1);
        Product product1 = new Product();
        product.setId(2);
        user.getWishList().add(product);
        user.getWishList().add(product1);

        wishListService.deleteFromWishList(user, product);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Assert.assertEquals(1, user.getWishList().size());
    }
}