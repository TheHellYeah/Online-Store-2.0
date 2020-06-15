package kostuchenkov.rgr.model.domain.user;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.repository.CartRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -1987177972808846853L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String contactInfo;
    private String avatar;
    private int balance;

    private boolean verified;
    private String activationCode;

    @Temporal(value = TemporalType.DATE)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private UserWishListAccess wishListAccess;

    @ManyToMany
    @JoinTable(name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> wishList = new ArrayList<>();

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CartItem> cart = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getCartTotal() {
        int cartTotal = 0;
        for(CartItem cartItem : cart) {
            cartTotal += cartItem.getProduct().getPrice() * cartItem.getAmount();
        }
        return cartTotal;
    }

    public boolean isSeller(){
        return roles.contains(UserRole.SELLER);
    }

    public boolean isAdmin() { return roles.contains(UserRole.ADMIN); }

    public boolean isWishListPublic() { return this.wishListAccess.equals(UserWishListAccess.PUBLIC); }

    //Возвращает cartItem c корзины если таковой имеется, иначе null
    public CartItem getProductFromCart(CartItem item) {
        return this.getCart().stream()
                    .filter(cartItem -> cartItem.equals(item))
                    .findFirst()
                    .orElse(null);
    }
}