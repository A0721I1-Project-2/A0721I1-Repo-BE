package project2.service;

import project2.model.Product;

import java.util.Optional;

public interface IProductService {
    //HuyNN
    Optional<Product> getProductById(Long id);
    Product updateProduct(Product product);

}
