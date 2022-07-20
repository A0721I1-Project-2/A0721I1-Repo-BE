package project2.service;
import java.util.List;
import project2.model.Product;

import project2.model.Product;

import java.util.Optional;

import project2.model.Product;

import java.util.List;

public interface IProductService {

    Product postProduct(Product product);
    List<Product> findAll();

    //HuyNN
    Optional<Product> getProductById(Long id);
    //HuyNN
    void updateCurrentPrice(Product product);
    //VinhTQ
    Product findProductById(long id);
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
