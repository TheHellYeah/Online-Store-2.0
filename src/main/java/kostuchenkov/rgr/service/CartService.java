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
        User us = userRepository.findByUsername(user.getUsername());
        us.getCart().put(product, count);
        userRepository.save(us);
        return true;
    }

    public boolean clearCart(User user){
        User us = userRepository.findByUsername(user.getUsername());
        us.getCart().clear();
        userRepository.save(us);
        return true;
    }

    public boolean deleteFromCart(User user,Product product){
        User us = userRepository.findByUsername(user.getUsername());
        us.getCart().remove(product);
        userRepository.save(us);
        return true;
    }
}
