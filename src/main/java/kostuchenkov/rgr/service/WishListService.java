package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.domain.user.UserRole;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    private UserRepository userRepository;

    public boolean addToWishList(User user, Product product) throws Exception {
        if(user.getWishList().contains(product)){
            return false;
        }else {
            user.getWishList().add(product);
            userRepository.save(user);
            return true;
        }
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
