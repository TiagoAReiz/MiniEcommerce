package tiago.Mini_Ecommerce.application.usecases;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.adapters.Mappers.ProductMap;
import tiago.Mini_Ecommerce.adapters.dtos.Product.CreateProduct;
import tiago.Mini_Ecommerce.adapters.repositories.ProductRepository;
import tiago.Mini_Ecommerce.core.entities.Product;
import tiago.Mini_Ecommerce.core.entities.UserEntity;
import tiago.Mini_Ecommerce.core.usecases.ProductUseCases;
import tiago.Mini_Ecommerce.core.usecases.UserUseCases;

import java.util.List;

@Service
public class ProductUseCasesImpl implements ProductUseCases {
    private final ProductRepository productRepository;
    private final ProductMap productMap;
    private final UserUseCases userUseCases;
    public ProductUseCasesImpl(ProductRepository productRepository, ProductMap productMap, UserUseCases userUseCases) {
        this.productRepository = productRepository;
        this.productMap = productMap;
        this.userUseCases = userUseCases;
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public ResponseEntity<Product> createProduct(CreateProduct product) {
        Product productEntity = productMap.toEntity(product);
        UserEntity sellerEntity = userUseCases.getUserById(product.sellerId());
        productEntity.setSeller(sellerEntity);
        return productRepository.createProduct(productEntity);
    }
}
