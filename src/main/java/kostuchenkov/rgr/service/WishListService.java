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
        User us = userRepository.findByUsername(user.getUsername());
        us.getWishList().add(product);
        userRepository.save(us);
    }

    public void clearWishList(User user){
        User us = userRepository.findByUsername(user.getUsername());
        us.getWishList().clear();
        userRepository.save(us);
    }

    public void deleteFromWishList(User user, Product product){
        User us = userRepository.findByUsername(user.getUsername());
        us.getWishList().remove(product);
        userRepository.save(us);
    }
}
