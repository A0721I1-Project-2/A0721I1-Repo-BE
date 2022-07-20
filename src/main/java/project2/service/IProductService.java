package project2.service;
import java.util.List;
import project2.model.Product;

import project2.model.Product;

import java.util.Optional;

import project2.model.Product;

import java.util.List;

public interface IProductService {
    //QuangNV write method get product in cart
    List<Product> getProductInCart(int i);

    void saveListProduct(List<Product> productList);

    //HuyNN
    Optional<Product> getProductById(Long id);
    //HuyNN
    void updateCurrentPrice(Product product);
    //VinhTQ
    Product findProductByIdForProductDetail(long id);
    //HauLST
    List<Product> getAllProductAuntion();
    //HauLST
    List<Product> getAllProductFinishedAuntion();
    //HauLST
    List<Product> gettAllProductAuntionAndTypeProduct(String nameTypeProduct);
    //HauLST
    List<Product> searchProductByNameByTypeProductByPrice(String nameProduct, String nameTypeProduct, Double min, Double max);
    //HauLST
    List<Product> searchProductPricesOver250(String nameProduct, String nameTypeProduct, Double min);

}
