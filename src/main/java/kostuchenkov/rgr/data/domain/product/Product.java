package kostuchenkov.rgr.data.domain.product;

import kostuchenkov.rgr.data.domain.Review;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "products")
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

    @MapKeyEnumerated(EnumType.STRING)
    @JoinColumn(name = "amount")
    @ElementCollection
    private Map<ProductSize, Integer> productAmount = new HashMap<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    public Product() {}

    public Product(String name, int price, String description, String category,
                   String subcategory, String brand, String season, int rating) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = ProductCategory.valueOf(category);
        this.subcategory = ProductSubcategory.valueOf(subcategory);
        this.brand = ProductBrand.valueOf(brand);
        this.season = ProductSeason.valueOf(season);
        this.rating = rating;
        //this.productAmount = productAmount;
    }

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

    public Map<ProductSize, Integer> getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Map<ProductSize, Integer> productAmount) {
        this.productAmount = productAmount;
    }
}
