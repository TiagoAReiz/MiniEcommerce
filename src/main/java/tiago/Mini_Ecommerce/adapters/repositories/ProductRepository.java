package tiago.Mini_Ecommerce.adapters.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tiago.Mini_Ecommerce.core.entities.Product;
import tiago.Mini_Ecommerce.infrastructure.jpaRepositories.ProductJpaRepository;

import java.util.List;

@Component
public class ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    public ProductRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }
    public ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.ok(productJpaRepository.save(product));
    }
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productJpaRepository.findAll());
    }
}
