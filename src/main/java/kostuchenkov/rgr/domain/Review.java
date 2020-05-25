package kostuchenkov.rgr.domain;

import kostuchenkov.rgr.domain.product.Product;
import kostuchenkov.rgr.domain.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String description;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    public Review() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}