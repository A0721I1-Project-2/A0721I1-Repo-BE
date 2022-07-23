package project2.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.List;

<<<<<<< HEAD
import java.util.Optional;

=======

import java.util.Optional;

import java.util.List;

>>>>>>> 87ec7cdcb8ec769e396cb8ea545a8baf6bc1c698

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    // QuangNV write method get product in cart
    @Override
    public List<Product> getProductInCart(int i) {
        return productRepository.getProductInCart(i);
    }
<<<<<<< HEAD
=======

>>>>>>> 87ec7cdcb8ec769e396cb8ea545a8baf6bc1c698
    @Override
    public void saveListProduct(List<Product> productList) {
        productRepository.saveAll(productList);
    }

<<<<<<< HEAD
=======

<<<<<<< HEAD

>>>>>>> 87ec7cdcb8ec769e396cb8ea545a8baf6bc1c698
=======
>>>>>>> d7902aaa82febe4cd90244fc3eedd1eccc80223f
    @Override
    public List<Product> getAllProductByEndDate(String statsBegin, String statsEnd, int biddingStatus) {
        System.out.println(productRepository.findProductByEndDateAndBiddingStatus(statsBegin, statsEnd, biddingStatus));
        return productRepository.findProductByEndDateAndBiddingStatus(statsBegin, statsEnd, biddingStatus);
    }
    //BachLT
    @Override
    public List<Product> getAllProductAtCurrentMonth(int curMonth, int biddingStatus) {
        System.out.println(productRepository.findProductByCurrentMonthAndBiddingStatus(curMonth, biddingStatus));
        return productRepository.findProductByCurrentMonthAndBiddingStatus(curMonth, biddingStatus);
    }
    //Thao
    @Override
    public  Product postProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id_product) {
        return productRepository.findById(id_product).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
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
    @Override
    public void updateCurrentPrice(Product product) {
        productRepository.save(product);
    }

    //VinhTQ
    @Override
    public Product findProductByIdForProductDetail(long id) {
        return productRepository.findProductByIdForProductDetail(id);
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