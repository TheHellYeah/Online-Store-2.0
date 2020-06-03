package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.order.Order;
import kostuchenkov.rgr.data.domain.order.OrderStatus;
import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.OrderRepository;
import kostuchenkov.rgr.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    public boolean createOrder(User user, String contact){
        user = userRepository.findByUsername(user.getUsername());
        Integer sum = 0 ;

        for (Map.Entry<Product, Integer> entry : user.getCart().entrySet() ){
            sum += entry.getKey().getPrice() * entry.getValue();
        }

        Order order = new Order();
        order.setDate(new Date());
        order.setContact(contact);
        order.setUser(user);
        order.setTotal(sum);
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
