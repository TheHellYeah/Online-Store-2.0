package kostuchenkov.rgr.service;


import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.review.Review;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewRepository reviewRepository;

    public  void recountRatingOfProduct(Product product){
        List<Review>  reviews = reviewRepository.findByProduct(product);
        float sum = 0;
        for(Review review : reviews){
            sum += review.getMark();
        }
        product.setRating(Math.round(sum/reviews.size()));
        productService.update(product);
    }

    public boolean addReviewToProduct(User user, int productId, String description, int mark ){
        Product product = productService.getProductById(String.valueOf(productId)).get();
        Review review = new Review();
        review.setDate(new Date());
        review.setMark(mark);
        review.setAuthor(user);
        if(product.getReviews().contains(review)) {
            //TODO
        }
        review.setDescription(description);
        review.setProduct(product);
        reviewRepository.save(review);
        this.recountRatingOfProduct(product);
        return true;
    }
}
