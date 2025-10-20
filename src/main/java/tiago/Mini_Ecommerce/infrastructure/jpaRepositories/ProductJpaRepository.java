package tiago.Mini_Ecommerce.infrastructure.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiago.Mini_Ecommerce.core.entities.Product;

public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
