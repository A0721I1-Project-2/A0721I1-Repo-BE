package project2.service;

import project2.model.Product;

import java.util.List;

public interface IProductService {
    Product postProduct(Product product);
    List<Product> findAll();
}
