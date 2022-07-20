package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.Optional;

import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Product postProduct(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();

//    //HuyNN
//    @Override
//    public Optional<Product> getProductById(Long id) {
//        return productRepository.findById(id);
//    }

        //HuyNN
//    @Override
//    public void updateCurrentPrice(Product product) {
//        productRepository.save(product);
//    }

        //VinhTQ
//    @Override
//    public Product findProductById(long id) {
//        return productRepository.findproductById(id);
//    }

        //HauLST
//    @Override
//    public List<Product> getAllProductAuntion() {
//        return productRepository.findAllProductAuction();
//    }

        //HauLST
//    @Override
//    public List<Product> getAllProductFinishedAuntion() {
//        return productRepository.findAllProductFinishedAuction();
//    }

        //HauLST
//    @Override
//    public List<Product> gettAllProductAuntionAndTypeProduct(String nameTypeProduct) {
//        return productRepository.gettAllProductAuntionAndTypeProduct(nameTypeProduct);
//    }

        //HauLST
//    @Override
//    public List<Product> searchProductByNameByTypeProductByPrice(String nameProduct, String nameTypeProduct, Double
//            min, Double max) {
//        return productRepository.searchProductByNameByTypeProductByPrice(nameProduct, nameTypeProduct, min, max);
//    }

//    //HauLST
//    @Override
//    public List<Product> searchProductPricesOver250(String nameProduct, String nameTypeProduct, Double min) {
//        return productRepository.searchProductPricesOver250(nameProduct, nameTypeProduct, min);
//    }
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void updateCurrentPrice(Product product) {
           iProductRepository.save(product);
    }

    @Override
    public Product findProductById(long id) {
        return iProductRepository.findproductById(id);
    }

    @Override
    public List<Product> getAllProductAuntion() {
        return iProductRepository.findAllProductAuction();
    }

    @Override
    public List<Product> getAllProductFinishedAuntion() {
        return iProductRepository.findAllProductFinishedAuction();
    }

    @Override
    public List<Product> gettAllProductAuntionAndTypeProduct(String nameTypeProduct) {
        return iProductRepository.gettAllProductAuntionAndTypeProduct(nameTypeProduct);
    }

    @Override
    public List<Product> searchProductByNameByTypeProductByPrice(String nameProduct, String nameTypeProduct, Double min, Double max) {
        return iProductRepository.searchProductByNameByTypeProductByPrice(nameProduct,nameTypeProduct,min,max);
    }

    @Override
    public List<Product> searchProductPricesOver250(String nameProduct, String nameTypeProduct, Double min) {
        return iProductRepository.searchProductPricesOver250(nameProduct,nameTypeProduct,min);
    }
}
