package tiago.Mini_Ecommerce.adapters.Mappers;

import org.springframework.stereotype.Component;
import tiago.Mini_Ecommerce.adapters.dtos.Seller.CreateSeller;
import tiago.Mini_Ecommerce.core.entities.Seller;

@Component
public class SellerMap {
    public Seller toEntity(CreateSeller sellerDto){
        Seller seller = new Seller();
        seller.setName(sellerDto.name());
        seller.setEmail(sellerDto.email());
        seller.setPassword(sellerDto.password());
        seller.setCpf(sellerDto.cpf());
        return seller;
    }
}
