package project2.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import project2.model.Product;

import project2.model.Product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import project2.model.Product;
import project2.repository.IProductRepository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project2.model.Product;

import java.util.List;
import java.util.Optional;

import project2.model.Product;

import java.util.List;

public interface IProductService {
    ResponseEntity save(Product product, Long idMember, List<MultipartFile> multipartFile);

    //QuangNV write method get product in cart
    List<Product> getProductInCart(int i);

    void saveListProduct(List<Product> productList);

    //HieuDV
    Page<Product> getAllNotDeletedYet(Pageable pageable);

    //HieuDV
    List<Product> getAllNotDeletedYet();

    //HieuDV
    Page<Product> getAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus, Pageable pageable);

    //HieuDV
    List<Product> getAllProductByNameTypeSellerPriceStatusNotPagination(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus);

    //HieuDV
    Optional<Product> getProductByIdProduct(Long id);

    //HieuDV
    void saveProduct(Product product);

    //BachLT
    List<Product> getAllProductByEndDate(String statsBegin, String statsEnd, int biddingStatus);

    //BachLT
    List<Product> getAllProductAtCurrentMonth(int curMonth, int biddingStatus);


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
