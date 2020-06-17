package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.review.Review;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.ReviewRepository;
import kostuchenkov.rgr.model.service.product.ProductService;
import kostuchenkov.rgr.model.service.review.ReviewService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @MockBean
    private ProductService productService;
    @MockBean
    private ReviewRepository reviewRepository;

    @Test
    void recountRatingOfProductTest() {
        Product product = new Product();
        Review review = new Review();
        List<Review> reviews = new ArrayList<>();
        review.setMark(2);
        reviews.add(review);
        review.setMark(3);
        reviews.add(review);
        Mockito.when(reviewRepository.findByProduct(product)).thenReturn(reviews);

        reviewService.recountRatingOfProduct(product);

        Assert.assertEquals(3, product.getRating());
    }

    @Test
    void addReviewToProductTest() throws Exception {
        Product product = new Product();
        User user = new User();
        user.setUsername("Artem");
        Mockito.when(productService.getProductById("1")).thenReturn(Optional.of(product));


        reviewService.addReviewToProduct(user, product, "Lalala", 5);

        Review review = product.getReviews().stream().findFirst().get();

        Assert.assertEquals( "Lalala", review.getDescription());
        Assert.assertEquals(5, review.getMark());
        Assert.assertEquals(user, review.getAuthor());
        Mockito.verify(reviewRepository, Mockito.times(1)).save(any());
    }
}