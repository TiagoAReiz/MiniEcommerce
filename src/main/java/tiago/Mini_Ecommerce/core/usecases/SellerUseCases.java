package tiago.Mini_Ecommerce.core.usecases;

import org.springframework.http.ResponseEntity;
import tiago.Mini_Ecommerce.adapters.dtos.Seller.CreateSeller;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.core.entities.Seller;
import tiago.Mini_Ecommerce.core.entities.UserEntity;

import java.util.List;

public interface SellerUseCases {
    ResponseEntity<List<Seller>> getAllSellers();
    ResponseEntity<Seller> createSeller(CreateSeller user);
    ResponseEntity<Void> updateSeller(CreateSeller Seller);
    Seller getSellerById(Long id);
    ResponseEntity<Void> deleteSeller(int id);
}
