package kostuchenkov.rgr.model.domain.product;

import kostuchenkov.rgr.model.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

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
    @Enumerated(EnumType.STRING)
    private ProductMaterial material;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ElementCollection
    @OrderColumn(name = "product_id")
    private Set<String> images = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "size")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "amount")
    private Map<ProductSize, Integer> sizes = new HashMap<>();
}
