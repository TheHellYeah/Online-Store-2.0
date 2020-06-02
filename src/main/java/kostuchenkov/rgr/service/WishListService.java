package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    private UserRepository userRepository;

    public void addToWishList(User user, Product product){
        user.getWishList().add(product);
        userRepository.save(user);
    }

    public void clearWishList(User user){
        user.getWishList().clear();
        userRepository.save(user);
    }

    public void deleteFromWishList(User user, Product product){
        user.getWishList().remove(product);
        userRepository.save(user);
    }
}
