package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;

    public void addToCart(User user, Product product, int count){
     //   user.getCart().put(product, count);
        userRepository.save(user);
    }

    public void clearCart(User user){
        user.getCart().clear();
        userRepository.save(user);
    }

    public void deleteFromCart(User user,Product product){
        user.getCart().remove(product);
        userRepository.save(user);
    }
}
