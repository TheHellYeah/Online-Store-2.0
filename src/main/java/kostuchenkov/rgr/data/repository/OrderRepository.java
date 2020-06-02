package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.order.Order;
import kostuchenkov.rgr.data.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List <Order> findByUser(User user);


}
