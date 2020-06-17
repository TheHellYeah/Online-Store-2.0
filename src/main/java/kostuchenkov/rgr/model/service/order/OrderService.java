package kostuchenkov.rgr.model.service.order;

import freemarker.template.TemplateException;
import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderPayment;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.OrderRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import kostuchenkov.rgr.model.service.cart.CartService;
import kostuchenkov.rgr.model.service.mail.MailService;
import kostuchenkov.rgr.web.utils.validation.OrderCheckoutForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    boolean createOrder(User user, OrderCheckoutForm checkoutForm) throws TemplateException, IOException, MessagingException;

    List<Order> getAllOrderOfUser(User user);

    List<Order> getAllOrders();

    List<Order> getAllOrdersWithStatus(OrderStatus orderStatus);

    void setStatus(Order order, OrderStatus orderStatus) throws TemplateException, IOException, MessagingException;

    Optional<Order> getOrderById(int orderId);
}
