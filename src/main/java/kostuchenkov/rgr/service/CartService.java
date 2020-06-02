package kostuchenkov.rgr.service;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;
import kostuchenkov.rgr.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;

    public boolean addToCart(User user, Product product, int count){
        user.getCart().put(product, count);
        userRepository.save(user);
        return true;
    }

    public boolean clearCart(User user){
        user.getCart().clear();
        userRepository.save(user);
        return true;
    }

    public boolean deleteFromCart(User user,Product product){
        user.getCart().remove(product);
        userRepository.save(user);
        return true;
    }
}
