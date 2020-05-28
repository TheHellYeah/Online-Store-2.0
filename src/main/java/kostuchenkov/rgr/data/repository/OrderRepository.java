package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
