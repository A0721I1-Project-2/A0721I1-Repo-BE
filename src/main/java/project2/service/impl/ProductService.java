package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> origin/dev
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

<<<<<<< HEAD
import java.util.List;

<<<<<<< HEAD
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
=======
=======
>>>>>>> ba45e67be83e3e23bc85fa933ae87c535cbf7fa4
import java.util.Optional;

import java.util.List;


import java.util.List;

import java.util.Optional;


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

<<<<<<< HEAD
    @Override
    public List<Product> getAllProductByEndDate(String statsBegin, String statsEnd, int biddingStatus) {
        System.out.println(productRepository.findProductByEndDateAndBiddingStatus(statsBegin, statsEnd, biddingStatus));
        return productRepository.findProductByEndDateAndBiddingStatus(statsBegin, statsEnd, biddingStatus);
    }

    @Override
    public List<Product> getAllProductAtCurrentMonth(int curMonth, int biddingStatus) {
        System.out.println(productRepository.findProductByCurrentMonthAndBiddingStatus(curMonth, biddingStatus));
        return productRepository.findProductByCurrentMonthAndBiddingStatus(curMonth, biddingStatus);
    }

    //HieuDV
    @Override
    public Page<Product> getAllNotDeletedYet(Pageable pageable) {
        return productRepository.findAllNotDeletedYet(pageable);
    }

    //HieuDV
    @Override
    public List<Product> getAllNotDeletedYet() {
        return productRepository.findAllNotDeletedYet();
    }

    //HieuDV
    @Override
    public Page<Product> getAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus, Pageable pageable) {
        return productRepository.findAllProductByNameTypeSellerPriceStatus(name, typeProduct, sellerName, maxPrice, minPrice, BiddingStatus, pageable);
    }

    //HieuDV
    @Override
    public List<Product> getAllProductByNameTypeSellerPriceStatusNotPagination(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus) {
        return productRepository.findAllProductByNameTypeSellerPriceStatus(name, typeProduct, sellerName, maxPrice, minPrice, BiddingStatus);
    }

    //HieuDV
    @Override
    public Optional<Product> getProductByIdProduct(Long id) {
        return productRepository.findById(id);
    }

    //HieuDV
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    //HuyNN
=======
>>>>>>> ba45e67be83e3e23bc85fa933ae87c535cbf7fa4
    @Override
    public Optional<Product> getProductById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void updateCurrentPrice(Product product) {
           iProductRepository.save(product);
    }

    @Override
<<<<<<< HEAD
    public Product findProductByIdForProductDetail(long id) {
        return productRepository.findProductByIdForProductDetail(id);
=======
    public Product findProductById(long id) {
        return iProductRepository.findproductById(id);
>>>>>>> ba45e67be83e3e23bc85fa933ae87c535cbf7fa4
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
<<<<<<< HEAD
        return productRepository.searchProductPricesOver250(nameProduct, nameTypeProduct, min);
>>>>>>> origin/dev
=======
        return iProductRepository.searchProductPricesOver250(nameProduct,nameTypeProduct,min);
>>>>>>> ba45e67be83e3e23bc85fa933ae87c535cbf7fa4
    }
}
