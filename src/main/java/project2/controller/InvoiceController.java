package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project2.config.MailPW;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
    ////tutt7 sendEmail
    @Autowired
    private JavaMailSender mailSender;
    @GetMapping("/sendMail")
    private ResponseEntity<Void> sendEmail(@RequestParam( name="img" ) String img,@RequestParam( name="mail",defaultValue = "") String mail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");

        helper.setFrom("\"contact@a0721i1.com\",");
        helper.setTo("thieuthanhtu1994@gmail.com");
        String subject = "Invoice-A0721I1-Aution Ltd.";
        helper.setSubject(subject);
        helper.setText("<div style=\"text-align: center\">\n" +
                "  <h3 style=\" color: blue\">Dear Friend !</h3>\n" +
                "  <p>\"We will send you a detailed payment invoice </p>\n" +
                "  <h3>Click </h3> <a href=\""+img+"\">Click</a>\n" +
                " <p> Thank You</p></div>", true);
        mailSender.send(message);
        return new ResponseEntity<>(null, HttpStatus.OK);
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
