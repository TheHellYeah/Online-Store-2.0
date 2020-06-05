package kostuchenkov.rgr.data.model.review;

import kostuchenkov.rgr.data.model.product.Product;
import kostuchenkov.rgr.data.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String description;
    private int mark;

    @Temporal(value = TemporalType.DATE)
    private Date date;
}