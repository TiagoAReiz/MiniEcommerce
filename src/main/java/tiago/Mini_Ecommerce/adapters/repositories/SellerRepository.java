package tiago.Mini_Ecommerce.adapters.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tiago.Mini_Ecommerce.adapters.dtos.Seller.CreateSeller;
import tiago.Mini_Ecommerce.core.entities.Seller;
import tiago.Mini_Ecommerce.infrastructure.jpaRepositories.SellerJpaRepository;

import java.util.List;
import java.util.Optional;

@Component
public class SellerRepository {
    private final SellerJpaRepository sellerJpaRepository;
    public SellerRepository(SellerJpaRepository sellerJpaRepository) {
        this.sellerJpaRepository = sellerJpaRepository;
    }
    public ResponseEntity<List<Seller>> getAllSellers(){
        return ResponseEntity.ok(sellerJpaRepository.findAll());
    }
    public Optional<Seller> getSellerById(Long id){
        return sellerJpaRepository.findById(id);
    }
    public Seller getSellerByEmail(String email) {
        return sellerJpaRepository.findByEmail(email);
    }
    public ResponseEntity<Seller> createSeller(Seller seller) {
        return ResponseEntity.ok(sellerJpaRepository.save(seller));
    }
}
