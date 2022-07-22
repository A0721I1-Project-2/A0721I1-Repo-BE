package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.ImageProduct;
import project2.model.Member;
import project2.model.Product;
import project2.model.TypeProduct;
import project2.service.IMemberService;
import project2.service.impl.ImageProductService;
import project2.service.impl.ProductService;
import project2.service.impl.TypeProductService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/manager/product/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProductService typeProductService;

    @Autowired
    private ImageProductService imageProductService;

    @Autowired
    private IMemberService iMemberService;


    @GetMapping("/type")
    public ResponseEntity<List<TypeProduct>>  findByAllTypeProduct() {
        List<TypeProduct> typeProducts = typeProductService.findByAll();
        if (typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(typeProducts,  HttpStatus.OK);
        }
    }

    @GetMapping("/img")
    public ResponseEntity<List<ImageProduct>> findByAllImageProduct() {
        List<ImageProduct> imageProducts = imageProductService.findByAll();
        if (imageProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(imageProducts,HttpStatus.OK);
        }
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id    ).get(), HttpStatus.OK);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        Optional<Member> member = iMemberService.findByIdMember(id);
        return new ResponseEntity<Member>(member.get() , HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity editProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
