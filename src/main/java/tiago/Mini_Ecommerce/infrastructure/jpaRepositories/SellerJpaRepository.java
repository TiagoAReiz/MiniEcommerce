package tiago.Mini_Ecommerce.infrastructure.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiago.Mini_Ecommerce.core.entities.Seller;

import java.util.Optional;


public interface SellerJpaRepository extends JpaRepository<Seller, Long> {
    Seller findByEmail(String email);
    Optional<Seller> findById(Long id);
}
