package kostuchenkov.rgr.data.domain.product;

import kostuchenkov.rgr.data.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
    private Map<ProductSize, Integer> sizes = new HashMap<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
