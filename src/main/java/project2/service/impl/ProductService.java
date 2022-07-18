package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    //VinhTQ
    @Override
    public Product findProductById(long id) {
        return productRepository.findproductById(id);
    }

    //HauLST
    @Override
    public List<Product> getAllProductAuntion() {
        return productRepository.findAllProductAuction();
    }

    //HauLST
    @Override
    public List<Product> getAllProductFinishedAuntion() {
        return productRepository.findAllProductFinishedAuction();
    }

    //HauLST
    @Override
    public List<Product> gettAllProductAuntionAndTypeProduct(String nameTypeProduct) {
        return productRepository.gettAllProductAuntionAndTypeProduct(nameTypeProduct);
    }

    //HauLST
    @Override
    public List<Product> searchProductByNameByTypeProductByPrice(String nameProduct, String nameTypeProduct, Double
            min, Double max) {
        return productRepository.searchProductByNameByTypeProductByPrice(nameProduct, nameTypeProduct, min, max);
    }

    //HauLST
    @Override
    public List<Product> searchProductPricesOver250(String nameProduct, String nameTypeProduct, Double min) {
        return productRepository.searchProductPricesOver250(nameProduct, nameTypeProduct, min);
    }
}
