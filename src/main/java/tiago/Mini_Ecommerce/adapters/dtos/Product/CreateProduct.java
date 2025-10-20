package tiago.Mini_Ecommerce.adapters.dtos.Product;

public record CreateProduct(  String name, String description, double price, int quantity, String category, Long sellerId) {
}
