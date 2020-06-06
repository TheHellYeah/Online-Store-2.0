package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import kostuchenkov.rgr.model.repository.CartRepository;
import kostuchenkov.rgr.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    public void addToCart(User user, Product product, ProductSize size){

        CartItem cartItem = new CartItem(user, product, size, 1);
        user.getCart().add(cartItem);
        System.out.println(user.getCart().toString());
        cartRepository.save(cartItem);
        userRepository.save(user);
    }

    public void clearCart(User user){
        user.getCart().clear();
        userRepository.save(user);
    }

    public void deleteFromCart(User user,Product product,ProductSize size){
        CartItem cartItem = cartRepository.findByUserAndProductAndSize(user,product,size);
        user.getCart().remove(cartItem);
        userRepository.save(user);
    }
}
