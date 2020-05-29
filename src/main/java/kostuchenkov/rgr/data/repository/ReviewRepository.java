package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
