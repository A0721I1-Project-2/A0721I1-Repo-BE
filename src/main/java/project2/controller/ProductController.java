package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Account;
import project2.model.Product;
import project2.service.IProductService;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/manager/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable() long id) {

        return new ResponseEntity<Product>(productService.findProductById(id), HttpStatus.BAD_REQUEST);
    }
}

