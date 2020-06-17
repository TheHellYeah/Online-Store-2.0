package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderPayment;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.OrderRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.model.service.cart.CartService;
import kostuchenkov.rgr.model.service.mail.MailService;
import kostuchenkov.rgr.model.service.order.OrderService;
import kostuchenkov.rgr.web.utils.validation.OrderCheckoutForm;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @MockBean
    private MailService mailService;
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CartService cartService;

    @Test
    void createOrderFailTest() throws Exception {
        User user = new User();
        user.setBalance(0);

        OrderCheckoutForm orderCheckoutForm = new OrderCheckoutForm();
        orderCheckoutForm.setFirstName("Artem");
        orderCheckoutForm.setSecondName("Kostuckenkov");
        orderCheckoutForm.setPatronymic("s");
        orderCheckoutForm.setOrderPayment(OrderPayment.BALANCE);
        orderCheckoutForm.setAddress("Ershov");
        orderCheckoutForm.setPhone("12345");

        Mockito.when(userRepository.findByUsername(any())).thenReturn(user);

        user.setCart(new ArrayList<>());
        CartItem cartItem = new CartItem();
        Product product = new Product();
        product.setPrice(12);
        product.setSizes(new HashMap<>());
        product.getSizes().put(ProductSize.SIZE_31, 10);
        cartItem.setProduct(product);
        cartItem.setAmount(1);
        cartItem.setSize(ProductSize.SIZE_31);

        user.getCart().add(cartItem);

        boolean isOrderSucceed = orderService.createOrder(user, orderCheckoutForm);
        Assert.assertFalse(isOrderSucceed);
        Mockito.verify(orderRepository, Mockito.times(0)).save(any());
        Mockito.verify(mailService, Mockito.times(0)).createOrderMail(any());
        Mockito.verify(cartService, Mockito.times(0)).clearCart(user);
    }

    @Test
    void setStatusTest() throws Exception {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PENDING);

        orderService.setStatus(order, OrderStatus.IN_TRANSIT);

        Assert.assertTrue(order.isInTransit());
        Mockito.verify(mailService, Mockito.times(1)).changeStatusOrder(order);
        Mockito.verify(orderRepository, Mockito.times(1)).save(order);
    }
}