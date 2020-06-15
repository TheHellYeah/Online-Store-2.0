package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.CartRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.model.service.cart.CartService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceTest {

    @Autowired
    private CartService cartService;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CartRepository cartRepository;

    @Test
    void addToCartFail() throws Exception {
        User user = new User();  //FIXME
        user.setId(1);
        Product product = new Product();
        product.setId(1);
        product.getSizes().put(ProductSize.SIZE_31, 3);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setUser(user);
        user.getCart().add(cartItem);

        boolean isAdded = cartService.addToCart(user, product, ProductSize.SIZE_30);
        Assert.assertFalse(isAdded);
        Mockito.verify(cartRepository, Mockito.times(0)).save(new CartItem());
    }

    @Test
    void addToCartNew() throws Exception {
        User user = new User();
        Product product = new Product();//FIXME

        boolean isAdded = cartService.addToCart(user, product, ProductSize.SIZE_31);
        Assert.assertTrue(isAdded);
        Mockito.verify(cartRepository, Mockito.times(1)).save(new CartItem());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);

    }

    @Test
    void addToCartExisting() throws Exception {
        User user = new User();
        Product product = new Product();//FIXME
        product.setId(1);
        product.getSizes().put(ProductSize.SIZE_31, 3);
        CartItem cartItem = new CartItem();
        user.getCart().add(cartItem);

        boolean isAdded = cartService.addToCart(user, product, ProductSize.SIZE_31);
        Assert.assertTrue(isAdded);
        Mockito.verify(cartRepository, Mockito.times(0)).save(any(CartItem.class));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void clearCart() {
        User user = new User();
        CartItem c1 = new CartItem();
        c1.setUser(user);
        c1.setProduct(new Product());
        CartItem c2 = new CartItem();
        c2.setUser(user);
        c2.setProduct(new Product());
        user.getCart().add(c1);
        user.getCart().add(c2);

        cartService.clearCart(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Assert.assertEquals(0, user.getCart().size());
    }

    @Test
    void deleteFromCart() {
        User user = new User();
        CartItem c1 = new CartItem();
        CartItem c2 = new CartItem();//FIXME
        c1.setId(1);
        c2.setId(2);
        user.setId(1);
        user.getCart().add(c1);
        user.getCart().add(c2);

        Mockito.when(cartRepository.findById(1)).thenReturn(Optional.of(c1));
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));

        cartService.deleteFromCart(user, 1);

        Assert.assertEquals(1, user.getCart().size());
        Mockito.verify(cartRepository, Mockito.times(1)).delete(c1);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}