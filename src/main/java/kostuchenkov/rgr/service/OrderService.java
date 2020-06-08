package kostuchenkov.rgr.service;

import freemarker.template.TemplateException;
import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderPayment;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.OrderRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    MailService mailService;

    public boolean createOrder(User user, String contact,String phone, String address, String payment) throws TemplateException, IOException, MessagingException {
        user = userRepository.findByUsername(user.getUsername());
        int sum = 0 ;
        for (CartItem cartItem : user.getCart() ){
            sum += cartItem.getProduct().getPrice() * cartItem.getAmount();
        }
        Order order = new Order();
        order.setAddress(address);
        order.setPhone(phone);
        order.setDate(new Date());
        order.setContact(contact);
        order.setUser(user);
        order.setTotal(sum);
        order.getProducts().addAll(user.getCart());
        order.setOrderPayment(OrderPayment.valueOf(payment));
        order.setOrderStatus(OrderStatus.PENDING);

        if(OrderPayment.valueOf(payment) == OrderPayment.BALANCE){
            if (user.getBalance() < order.getTotal())
                return false;
            else
                user.setBalance(user.getBalance()-order.getTotal());
        }
        mailService.createOrderMail(order);
        cartService.clearCart(user);
        orderRepository.save(order);
        return true;
    }

    public List<Order> getAllOrderOfUser(User user){
        user = userRepository.findByUsername(user.getUsername());
        return orderRepository.findByUser(user);
    }

    public List<Order> getAllOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public List<Order> getAllOrdersWithStatus(OrderStatus orderStatus){
        return orderRepository.findByOrderStatus(orderStatus);
    }
    public void setStatus(Order order, OrderStatus orderStatus) throws TemplateException, IOException, MessagingException {
        order.setOrderStatus(orderStatus);
        mailService.changeStatusOrder(order);
        orderRepository.save(order);
    }
    public Optional<Order> getOrderById(int orderId){
        return orderRepository.findById(orderId);
    }
}
