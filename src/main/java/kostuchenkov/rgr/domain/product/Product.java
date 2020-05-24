package kostuchenkov.rgr.domain.product;

import javax.persistence.*;

@Entity
@Table(name = "shoes")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int price;
    private int rating;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @Enumerated(EnumType.STRING)
    private ProductSubcategory subcategory;
    @Enumerated(EnumType.STRING)
    private ProductBrand brand;
    @Enumerated(EnumType.STRING)
    private ProductSeason season;

    public Product() {}

    public void setId(Long id) {
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

    public Long getId() {
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

    public ProductCategory getCategory() {
        return category;
    }

    public ProductSubcategory getSubcategory() {
        return subcategory;
    }

    public ProductBrand getBrand() {
        return brand;
    }

    public ProductSeason getSeason() {
        return season;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setSubcategory(ProductSubcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void setBrand(ProductBrand brand) {
        this.brand = brand;
    }

    public void setSeason(ProductSeason season) {
        this.season = season;
    }
}
