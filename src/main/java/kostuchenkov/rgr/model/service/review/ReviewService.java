package kostuchenkov.rgr.model.service.review;


import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.review.Review;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.ReviewRepository;
import kostuchenkov.rgr.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface ReviewService {

    void recountRatingOfProduct(Product product);

    boolean addReviewToProduct(User user, int productId, String description, int mark );
}
