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

/*    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "products_key") // не работает, колонка с названием cart_key хз почему
    @Column(name = "amount")
    private Map<Product, Integer> products = new HashMap<>();*/

    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<CartItem> products = new ArrayList<>();

    @Column(name = "total")
    private int total;

    @Column(name = "contact")
    private String contact;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
