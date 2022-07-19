package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Product;
import project2.service.IProductService;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/manager/product/api")
public class ProductController {
    @Autowired
    private IProductService productService;

    //VinhTQ
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> findProductByIdForProductDetail(@PathVariable() long id) {
        return new ResponseEntity<Product>(productService.findProductByIdForProductDetail(id), HttpStatus.OK);
    }
    //VinhTQ
    @GetMapping("/highest-bidder/{id}")
    public ResponseEntity<Product> finForProductDetail(@PathVariable() long id) {
        return new ResponseEntity<Product>(productService.findProductByIdForProductDetail(id), HttpStatus.OK);
    }
    //HauLST
    @GetMapping("/list/auction")
    public ResponseEntity<List<Product>> showListProductAuction() {
        List<Product> productList = productService.getAllProductAuntion();

        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        } else {
          }
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        }
    // HauLST
    @GetMapping("/list/finished-auction")
    public ResponseEntity<List<Product>> showListProductFinishedAuction() {
        List<Product> productList = productService.getAllProductFinishedAuntion();
        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    //HauLST
    @GetMapping("/list/auction/{typeProduct}")
    public ResponseEntity<List<Product>> showListProductAuctionAndTypeProduct(@PathVariable String typeProduct) {
        List<Product> productList = productService.gettAllProductAuntionAndTypeProduct(typeProduct);
        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    //HauLST
    @GetMapping("list/search/name={nameProduct}/type-product={typeProduct}/{min}/{max}")
    public ResponseEntity<List<Product>> searchNameAndTypeAndPrices(@PathVariable String nameProduct, @PathVariable String typeProduct, @PathVariable Double min, @PathVariable Double max) {
        List<Product> productList = productService.searchProductByNameByTypeProductByPrice(nameProduct, typeProduct, min, max);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //HauLST
    @GetMapping("list/search/name={nameProduct}/type-product={typeProduct}/{min}")
    public ResponseEntity<List<Product>> searchPricesOver250(@PathVariable String nameProduct, @PathVariable String typeProduct, @PathVariable Double min) {
        List<Product> productList = productService.searchProductPricesOver250(nameProduct, typeProduct, min);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}

