package tiago.Mini_Ecommerce.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiago.Mini_Ecommerce.adapters.dtos.Seller.CreateSeller;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.core.entities.Seller;
import tiago.Mini_Ecommerce.core.entities.UserEntity;
import tiago.Mini_Ecommerce.core.usecases.SellerUseCases;
import tiago.Mini_Ecommerce.core.usecases.UserUseCases;

import java.util.List;

@RestController
@RequestMapping("sellers")
public class SellerController {
    private final SellerUseCases sellerUseCases;

    public SellerController(SellerUseCases sellerUseCases) {
        this.sellerUseCases = sellerUseCases;
    }
    @GetMapping
    public ResponseEntity<List<Seller>> getAllUsers(){
        return sellerUseCases.getAllSellers();
    }
    @PostMapping("/create")
    public ResponseEntity<Seller> createUser(@RequestBody CreateSeller seller) {
        return sellerUseCases.createSeller(seller);
    }

}