package kostuchenkov.rgr.model.repository;

import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.order.OrderStatus;
import kostuchenkov.rgr.model.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findByUser(User user);

    List<Order> findByOrderStatus(OrderStatus orderStatus);
}
