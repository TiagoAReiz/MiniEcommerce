package tiago.Mini_Ecommerce.adapters.Mappers;

import org.springframework.stereotype.Component;
import tiago.Mini_Ecommerce.adapters.dtos.Product.CreateProduct;
import tiago.Mini_Ecommerce.core.entities.Product;

@Component
public class ProductMap {
    public Product toEntity(CreateProduct createProduct) {
        Product product = new Product();
        product.setName(createProduct.name());
        product.setDescription(createProduct.description());
        product.setPrice(createProduct.price());
        product.setQuantity(createProduct.quantity());
        product.setCategory(createProduct.category());
        return product;
    }
}
