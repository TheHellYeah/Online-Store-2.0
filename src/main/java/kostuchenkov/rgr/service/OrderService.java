package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.OrderRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean createOrder(User user, String contact,String phone, String address){
        user = userRepository.findByUsername(user.getUsername());
        Integer sum = 0 ;

        for (Map.Entry<Product, Integer> entry : user.getCart().entrySet() ){
            sum += entry.getKey().getPrice() * entry.getValue();
        }

        Order order = new Order();
        order.setAddress(address);
        order.setPhone(phone);
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

    public List<Order> getAllOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public List<Order> getAllOrdersWithStatus(OrderStatus orderStatus){
        return orderRepository.findByOrderStatus(orderStatus);
    }
    public void setStatus(Order order, OrderStatus orderStatus){
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
    }
    public Optional<Order> getOrderById(int orderId){
        return orderRepository.findById(orderId);
    }
}
