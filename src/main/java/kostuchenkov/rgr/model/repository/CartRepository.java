package kostuchenkov.rgr.model.repository;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Integer> {
}
