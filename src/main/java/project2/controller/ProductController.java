package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project2.model.Product;
import project2.service.IProductService;
import project2.service.impl.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Product;
import project2.service.IProductService;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/manager/product/api")

public class ProductController {

    @Autowired
    private IProductService productService;

    //  BachLT
    @GetMapping("/statistic/{statsBegin}&{statsEnd}&{biddingStatus}")
    public ResponseEntity<List<Product>> statsProductFromDateToDate(@PathVariable Optional<String> statsBegin, @PathVariable Optional<String> statsEnd, @PathVariable("biddingStatus") int biddingStatus) {
        System.out.println(statsBegin.get() + "?- ?" + statsEnd.get() + "/? " + biddingStatus);
        List<Product> productList = productService.getAllProductByEndDate(statsBegin.get(), statsEnd.get(), biddingStatus);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //  BachLT
    @GetMapping("/statistic/currentMonth&biddingStatus")
    public ResponseEntity<List<Product>> statsProductCurrentMonth(@RequestParam("currentMonth") int curMonth, @RequestParam("biddingStatus") int biddingStatus) {
        System.out.println(curMonth + "?- ?" + biddingStatus);
        List<Product> productList = productService.getAllProductAtCurrentMonth(curMonth, biddingStatus);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    private IProductService iProductService;


    //HieuDV
    @GetMapping("/list")
    public ResponseEntity<Iterable<Product>> getAllNotDeletedYet(@RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> productList = iProductService.getAllNotDeletedYet(pageable);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //HieuDV
    @GetMapping("/list-not-pagination")
    public ResponseEntity<List<Product>> getAllNotDeletedYetNotPagination() {
        List<Product> productList = iProductService.getAllNotDeletedYet();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //HieuDV
    @GetMapping("/search")
    public ResponseEntity<Iterable<Product>> getAllProductByNameTypeSellerPriceStatus(@RequestParam(defaultValue = "") String name,
                                                                                      @RequestParam(defaultValue = "") String typeProduct,
                                                                                      @RequestParam(defaultValue = "") String sellerName,
                                                                                      @RequestParam(defaultValue = "") String maxPrice,
                                                                                      @RequestParam(defaultValue = "") String minPrice,
                                                                                      @RequestParam(defaultValue = "") String biddingStatus,
                                                                                      @RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> productList = iProductService.getAllProductByNameTypeSellerPriceStatus(name, typeProduct, sellerName, maxPrice, minPrice, biddingStatus, pageable);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //HieuDV
    @GetMapping("/search-not-pagination")
    public ResponseEntity<List<Product>> getAllProductByNameTypeSellerPriceStatusNotPagination(@RequestParam(defaultValue = "") String name,
                                                                                               @RequestParam(defaultValue = "") String typeProduct,
                                                                                               @RequestParam(defaultValue = "") String sellerName,
                                                                                               @RequestParam(defaultValue = "") String maxPrice,
                                                                                               @RequestParam(defaultValue = "") String minPrice,
                                                                                               @RequestParam(defaultValue = "") String BiddingStatus) {
        List<Product> productList = iProductService.getAllProductByNameTypeSellerPriceStatusNotPagination(name, typeProduct, sellerName, maxPrice, minPrice, BiddingStatus);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //HieuDV
    @GetMapping("/product-detail")
    public ResponseEntity<Product> getProductByIdProduct(@RequestParam Long id) {
        Optional<Product> product = iProductService.getProductByIdProduct(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    //HieuDV
    @PostMapping("/update-bidding-status")
    public ResponseEntity<Product> updateProductBiddingStatus(@RequestBody Product product) {
        iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
