package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.ApprovalStatus;
import project2.model.ImageProduct;
import project2.model.Product;
import project2.model.TypeProduct;
import project2.service.IApprovalStatusService;
import project2.service.IProductService;
import project2.service.ITypeProductService;
import project2.service.impl.BiddingStatusService;
import project2.service.impl.ImageProductService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ImageProductService imageProductService;
    @Autowired
    private ITypeProductService iTypeProductService;
    @Autowired
    private IApprovalStatusService iApprovalStatusService;
    @Autowired
    private BiddingStatusService biddingStatusService;

    @RequestMapping(value = "listProduct", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findByAll() {
        List<Product> productList = iProductService.findAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }
    @RequestMapping(value = "postProduct", method = RequestMethod.POST)
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        product.setStartDate(LocalDateTime.now());
        product.setEndDate(LocalDateTime.now());
        product.setBiddingStatus(biddingStatusService.findById((long)1));
        List<ApprovalStatus>approvalStatusList= iApprovalStatusService.findAllBy();
        for(ApprovalStatus a : approvalStatusList){
            if(a.getIdApprovalStatus()==1){
                /* Get approval status by id */
                ApprovalStatus approvalStatus = iApprovalStatusService.getApprovalStatusById(a.getIdApprovalStatus());
               product.setApprovalStatus(approvalStatus);
            }
        }
        product.setApprovalStatus(iApprovalStatusService.getApprovalStatusById((long)2));
        Product productCreated = iProductService.postProduct(product);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);

    }
    @RequestMapping(value = "/typeProduct",method = RequestMethod.GET)
    public ResponseEntity<List<TypeProduct>> findByAllTypeproduct() {
        List<TypeProduct> typeProducts = iTypeProductService.findByAll();
        if (typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(typeProducts, HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/create-images", method = RequestMethod.POST)
    public ResponseEntity<ImageProduct> createImages(@RequestBody ImageProduct imageProduct) {
        /* Save each picture */
        ImageProduct imageProduct1= imageProductService.save(imageProduct);
        return new ResponseEntity<>(imageProduct1 , HttpStatus.OK);
    }
    @RequestMapping(value = "typeProduct/{id}",method = RequestMethod.GET)
    public ResponseEntity<TypeProduct> getTypeProductById(@PathVariable long id){
        return new ResponseEntity<TypeProduct>(iTypeProductService.findById(id),HttpStatus.OK);
    }
}
