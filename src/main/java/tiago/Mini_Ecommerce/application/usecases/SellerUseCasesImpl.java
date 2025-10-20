package tiago.Mini_Ecommerce.application.usecases;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.adapters.Mappers.SellerMap;
import tiago.Mini_Ecommerce.adapters.dtos.Seller.CreateSeller;
import tiago.Mini_Ecommerce.adapters.repositories.SellerRepository;
import tiago.Mini_Ecommerce.core.entities.Seller;
import tiago.Mini_Ecommerce.core.usecases.SellerUseCases;

import java.util.List;
import java.util.Optional;


@Service
public class SellerUseCasesImpl implements SellerUseCases {
    private final SellerRepository sellerRepository;
    private final SellerMap sellerMap;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public SellerUseCasesImpl(SellerRepository sellerRepository, SellerMap sellerMap, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.sellerRepository = sellerRepository;
        this.sellerMap = sellerMap;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public ResponseEntity<List<Seller>> getAllSellers() {
        return sellerRepository.getAllSellers();
    }

    @Override
    public ResponseEntity<Seller> createSeller(CreateSeller seller) {
        if (sellerRepository.getSellerByEmail(seller.email()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Seller sellerEntity = sellerMap.toEntity(seller);
        sellerEntity.setPassword(bCryptPasswordEncoder.encode(seller.password()));
        return sellerRepository.createSeller(sellerEntity);
    }
    @Override
    public Seller getSellerById(Long id) {
        if(sellerRepository.getSellerById(id).isPresent()){
            return sellerRepository.getSellerById(id).get();
        };
        return null;
    }

    @Override
    public ResponseEntity<Void> updateSeller(CreateSeller Seller) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteSeller(int id) {
        return null;
    }

}

