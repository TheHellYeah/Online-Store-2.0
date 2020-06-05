package kostuchenkov.rgr.model.repository;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.review.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findByProduct(Product product);
}
