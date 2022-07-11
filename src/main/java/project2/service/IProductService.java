package project2.service;

import project2.model.Product;

import java.util.List;

public interface IProductService {
    //QuangNV write method get product in cart
    List<Product> getProductInCart(int i);
}
