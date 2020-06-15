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

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public  void recountRatingOfProduct(Product product){
        List<Review> reviews = product.getReviews();
        float sum = 0;
        for(Review review : reviews){
            sum += review.getMark();
        }
        product.setRating(Math.round(sum/reviews.size()));
        productService.update(product);
    }

    @Override
    public boolean addReviewToProduct(User user, Product product, String description, int mark ){
        if(product != null) {

            Review review = reviewRepository.findByProductAndAuthor(product, user);

            if(review != null) {
                review.setDescription(description);
                review.setMark(mark);
            } else {
                review = new Review();
                review.setDate(new Date());
                review.setMark(mark);
                review.setAuthor(user);
                review.setDescription(description);
                review.setProduct(product);
                product.getReviews().add(review);
            }
            reviewRepository.save(review);
            this.recountRatingOfProduct(product);
            return true;
        }
        return false;
    }
}
