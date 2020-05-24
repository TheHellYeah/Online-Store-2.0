package kostuchenkov.rgr.domain;

import kostuchenkov.rgr.domain.product.Product;
import kostuchenkov.rgr.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private User user;
    private Product product;
    private String description;

    public Review() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }
}