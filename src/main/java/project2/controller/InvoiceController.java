package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project2.dto.InvoiceDTO;
import project2.model.ImageProduct;
import project2.model.InvoiceDetail;
import project2.service.impl.InvoiceDetailService;

import java.util.List;

@RestController
@RequestMapping("/manager/invoice-status/api")
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;
    @GetMapping("/status")
    public ResponseEntity<List<InvoiceDetail>> findAllStatusInvoice() {
        List<InvoiceDetail> invoices = invoiceDetailService.findAllStatusInvoice();
        if (invoices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(invoices, HttpStatus.OK);
        }
    }

//    @GetMapping("/img_product")
//    public ResponseEntity<List<ImageProduct>> findAllImageprodut(@RequestParam int id) {
//        List<ImageProduct> list = invoiceDetailService.findAllImageProduct(id);
//        if (list.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity(list, HttpStatus.OK);
//        }
//    }
}
