package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
