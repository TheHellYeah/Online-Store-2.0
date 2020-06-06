package kostuchenkov.rgr.model.domain.cartItem;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
import kostuchenkov.rgr.model.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    private int amount;

    @Enumerated(value = EnumType.STRING)
    private ProductSize size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartItem(User user,Product product, ProductSize size, int amount) {
        this.user = user;
        this.product = product;
        this.size = size;
        this.amount = amount;
    }

    public int getProductId() {
        return this.product.getId();
    }
}