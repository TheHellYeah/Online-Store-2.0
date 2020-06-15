package kostuchenkov.rgr.model.service.cart;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;

public interface CartService {

    boolean addToCart(User user, Product product, ProductSize size);

    void clearCart(User user);

    void deleteFromCart(User user, Integer cartItemId);

    boolean updateCart(CartItem cartItem, int value);
}
