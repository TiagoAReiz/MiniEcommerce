package tiago.Mini_Ecommerce.application.usecases;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.adapters.Mappers.ProductMap;
import tiago.Mini_Ecommerce.adapters.dtos.Product.CreateProduct;
import tiago.Mini_Ecommerce.adapters.repositories.ProductRepository;
import tiago.Mini_Ecommerce.core.entities.Product;
import tiago.Mini_Ecommerce.core.entities.Seller;
import tiago.Mini_Ecommerce.core.usecases.ProductUseCases;
import tiago.Mini_Ecommerce.core.usecases.SellerUseCases;

import java.util.List;

@Service
public class ProductUseCasesImpl implements ProductUseCases {
    private final ProductRepository productRepository;
    private final ProductMap productMap;
    private final SellerUseCases sellerUseCases;
    public ProductUseCasesImpl(ProductRepository productRepository, ProductMap productMap, SellerUseCases sellerUseCases) {
        this.productRepository = productRepository;
        this.productMap = productMap;
        this.sellerUseCases = sellerUseCases;
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public ResponseEntity<Product> createProduct(CreateProduct product) {
        Product productEntity = productMap.toEntity(product);
        Seller sellerEntity = sellerUseCases.getSellerById(product.sellerId());
        productEntity.setSeller(sellerEntity);
        return productRepository.createProduct(productEntity);
    }
}
