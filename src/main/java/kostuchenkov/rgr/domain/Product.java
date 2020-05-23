package kostuchenkov.rgr.domain;

import javax.persistence.*;

@Entity
@Table(name = "shoes")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int price;
    private int rating;
    private String description;

    private enum Category {
        MALE,
        FEMALE,
        CHILD
    }
    private enum Subcategory {
        SNEAKERS,
        GYMSHOES,
        LOW_SHOES,
        SANDALS,
        SLIPPERS
    }
    private enum Brand {
        NIKE,
        ADIDAS,
        RIEKER,
        PUMA,
        RALP_RINGER
    }
    private enum Season {
        SUMMER,
        AUTUMN,
        WINTER,
        SPRING
    }

    public Product() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }
}
