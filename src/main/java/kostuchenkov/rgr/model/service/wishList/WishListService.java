package kostuchenkov.rgr.model.service.wishList;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface WishListService {

    boolean addToWishList(User user, Product product);

    void clearWishList(User user);

    void deleteFromWishList(User user, Product product);
}
