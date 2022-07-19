package project2.service;

import project2.model.Product;

import java.util.Optional;

public interface IProductService {
    Optional<Product> getProductById(Long id);
    void updateCurrentPrice(Product product);
}
