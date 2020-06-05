package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.model.order.Order;
import kostuchenkov.rgr.data.model.order.OrderStatus;
import kostuchenkov.rgr.data.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List <Order> findByUser(User user);
    List<Order> findByOrderStatus(OrderStatus orderStatus);
}
