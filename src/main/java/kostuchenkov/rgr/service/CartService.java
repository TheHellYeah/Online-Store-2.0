package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.CartRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    public void addToCart(User user, Product product, ProductSize size){

        CartItem cartItem = new CartItem(user, product, size, 1);
        CartItem existingItem = user.getProductFromCart(cartItem);

        if (existingItem != null) {
            existingItem.incrementAmount();
            cartRepository.save(existingItem);
        } else {
            user.getCart().add(cartItem);
            cartRepository.save(cartItem);
            userRepository.save(user);
        }
    }

    public void clearCart(User user){
        user.getCart().clear();
        userRepository.save(user);
    }

    public void deleteFromCart(User user, Integer cartId){
        user = userRepository.findById(user.getId()).get();
        CartItem cartItem = cartRepository.findById(cartId).get();

        user.getCart().remove(cartItem);
        userRepository.save(user);
        cartRepository.deleteById(cartId);
    }
}
