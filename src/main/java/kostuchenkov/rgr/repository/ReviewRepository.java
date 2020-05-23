package kostuchenkov.rgr.repository;

import kostuchenkov.rgr.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
