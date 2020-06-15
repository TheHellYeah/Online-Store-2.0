package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.repository.OrderRepository;
import kostuchenkov.rgr.model.service.mail.MailService;
import kostuchenkov.rgr.model.service.order.OrderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @MockBean
    private MailService mailService;
    @MockBean
    private OrderRepository orderRepository;

    @Test //TODO
    void createOrder() {
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