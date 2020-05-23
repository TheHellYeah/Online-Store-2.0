package kostuchenkov.rgr.repository;

import kostuchenkov.rgr.domain.Wishlist;
import org.springframework.data.repository.CrudRepository;

public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
}
