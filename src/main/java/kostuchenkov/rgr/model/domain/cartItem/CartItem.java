package kostuchenkov.rgr.model.domain.cartItem;

import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.product.ProductSize;
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

    private int amount;

    @Enumerated(value = EnumType.STRING)
    private ProductSize size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartItem(Product product, ProductSize size, int amount) {
        this.product = product;
        this.size = size;
        this.amount = amount;
    }

    public int getProductId() {
        return this.product.getId();
    }
}