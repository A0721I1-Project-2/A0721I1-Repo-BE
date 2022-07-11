package project2.service;

import project2.model.Product;

import java.util.List;

public interface IProductService {
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
