package kostuchenkov.rgr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private User user;
    private List<Product> products;

    public Cart() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductList(List<Product> products) {
        this.products = products;
    }

    public int getId() {

        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return products;
    }
}
