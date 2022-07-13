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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/manager/product/api")
public class ProductController {

    @Autowired
    private IProductService productService;

    //    ?statsBegin={statsBegin}&statsEnd={statsEnd}
    @PostMapping("/statistic/{statsBegin}/{statsEnd}")
    public ResponseEntity<List<Product>> getAllProductList(@PathVariable Optional<String> statsBegin, @PathVariable Optional<String> statsEnd) {
        List<Product> productList = productService.getAllProductByEndDate(statsBegin.get(), statsEnd.get());
        if (productList == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

}
