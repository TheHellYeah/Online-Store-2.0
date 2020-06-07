package kostuchenkov.rgr.model.domain.order;

import kostuchenkov.rgr.model.domain.cartItem.CartItem;
import kostuchenkov.rgr.model.domain.product.Product;
import kostuchenkov.rgr.model.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<CartItem> products = new ArrayList<>();

    private int total;
    private String contact;
    private String address;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private OrderPayment orderPayment;

    public boolean isDelivered() {
        return orderStatus.equals(OrderStatus.DELIVERED);
    }

    public boolean isInTransit() {
        return orderStatus.equals(OrderStatus.IN_TRANSIT);
    }

    public boolean isPending() {
        return orderStatus.equals(OrderStatus.PENDING);
    }
}
