package tiago.Mini_Ecommerce.core.usecases;

import org.springframework.http.ResponseEntity;
import tiago.Mini_Ecommerce.adapters.dtos.Product.CreateProduct;
import tiago.Mini_Ecommerce.core.entities.Product;

import java.util.List;

public interface ProductUseCases {
    ResponseEntity<List<Product>> getAllProducts();
    ResponseEntity<Product> createProduct(CreateProduct product);
}
