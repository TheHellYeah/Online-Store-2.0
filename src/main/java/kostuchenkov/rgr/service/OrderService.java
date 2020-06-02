package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.order.Order;
import kostuchenkov.rgr.data.domain.order.OrderStatus;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.OrderRepository;
import kostuchenkov.rgr.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;



    public boolean createOrder(User user, String contact){
        user = userRepository.findByUsername(user.getUsername());

        Order order = new Order();
        order.setContact(contact);
        order.setUser(user);
        order.getProducts().putAll(user.getCart());
        order.setOrderStatus(OrderStatus.PENDING);

        orderRepository.save(order);
        return true;
    }

    public List<Order> getAllOrderOfUser(User user){
        user = userRepository.findByUsername(user.getUsername());
        return orderRepository.findByUser(user);
    }

}
