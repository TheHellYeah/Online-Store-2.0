package kostuchenkov.rgr.repository;

import kostuchenkov.rgr.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
