package kostuchenkov.rgr;

import kostuchenkov.rgr.data.domain.product.Product;
import kostuchenkov.rgr.data.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
