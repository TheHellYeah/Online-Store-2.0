package kostuchenkov.rgr.data.domain;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.domain.user.User;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    @ManyToMany
    private List<Product> products;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Order() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductList(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Date getDate() {
        return date;
    }
}
