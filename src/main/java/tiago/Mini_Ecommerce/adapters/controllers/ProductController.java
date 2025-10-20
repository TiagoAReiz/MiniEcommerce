package tiago.Mini_Ecommerce.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiago.Mini_Ecommerce.adapters.dtos.Product.CreateProduct;
import tiago.Mini_Ecommerce.core.entities.Product;
import tiago.Mini_Ecommerce.core.usecases.ProductUseCases;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductUseCases productUseCases;
    public ProductController(ProductUseCases productUseCases) {
        this.productUseCases = productUseCases;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return productUseCases.getAllProducts();
    }
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProduct product) {
        return productUseCases.createProduct(product);
    }
}
