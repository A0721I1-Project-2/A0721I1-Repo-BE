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
    @GetMapping("/statistic/{statsBegin}&{statsEnd}&{biddingStatus}")
    public ResponseEntity<List<Product>> statsProductFromDateToDate(@PathVariable Optional<String> statsBegin, @PathVariable Optional<String> statsEnd, @PathVariable("biddingStatus") int biddingStatus) {
        System.out.println(statsBegin.get() + "?- ?" + statsEnd.get()+"/? "+ biddingStatus);
        List<Product> productList = productService.getAllProductByEndDate(statsBegin.get(), statsEnd.get(), biddingStatus);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }


    @GetMapping("/statistic/currentMonth&biddingStatus")
    public ResponseEntity<List<Product>> statsProductCurrentMonth(@RequestParam("currentMonth") int curMonth, @RequestParam("biddingStatus") int biddingStatus) {
        System.out.println(curMonth + "?- ?" + biddingStatus);
        List<Product> productList = productService.getAllProductAtCurrentMonth(curMonth, biddingStatus);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
