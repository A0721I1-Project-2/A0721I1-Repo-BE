package project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import project2.model.Product;
import project2.repository.IProductRepository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project2.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
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

    //ToanPT
    Product getProductById(Long id);
    Product updateProduct(Product product);
}
