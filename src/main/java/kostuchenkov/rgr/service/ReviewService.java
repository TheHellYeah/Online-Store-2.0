package kostuchenkov.rgr.service;


import kostuchenkov.rgr.data.domain.review.Review;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.ProductRepository;
import kostuchenkov.rgr.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService {

    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewRepository reviewRepository;

    public boolean addReviewToProduct(User user, int productId, String description, int mark ){
        Review review = new Review(); //МБ Заюзать конструктор
        review.setDate(new Date());
        review.setMark(mark);
        review.setAuthor(user);
        review.setDescription(description);
        review.setProduct(productService.getProductById(String.valueOf(productId)).get());
        reviewRepository.save(review);
        return true;
    }
}
