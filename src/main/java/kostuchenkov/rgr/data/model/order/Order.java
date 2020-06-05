package kostuchenkov.rgr.data.model.order;

import kostuchenkov.rgr.data.model.product.Product;
import kostuchenkov.rgr.data.model.user.User;
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

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "products_key") // не работает, колонка с названием cart_key хз почему
    @Column(name = "amount")
    private Map<Product, Integer> products = new HashMap<>();

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
