package kostuchenkov.rgr.data.repository;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.review.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findByProduct(Product product);
}
