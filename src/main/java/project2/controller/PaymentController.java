package project2.controller;

import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.OrderProduct;
import project2.model.PaymentMethod;
import project2.model.Transport;
import project2.service.impl.PaymentMethodService;
import project2.service.impl.PaymentService;
import project2.service.impl.TransportService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("payment")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private TransportService transportService;

//    Get list paymen method
    @RequestMapping(value = "/payment-method", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentMethod>> getPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethod();
        if (paymentMethods.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
    }

    @RequestMapping(value = "/transport", method = RequestMethod.GET)
    public ResponseEntity<List<Transport>> getTransports() {
        List<Transport> transports = transportService.getAllTransport();
        if (transports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @RequestMapping(value = "/payer", method = RequestMethod.GET)
    public ResponseEntity<Payer> getPayer() {
        Payer payer = paymentMethodService.getPayerInformation();
        if (payer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payer, HttpStatus.OK);
    }

//    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
//    public ResponseEntity<List<Transaction>> getTransaction() {
//        String product = "test1";
//        String subtotal = "10";
//        String shipping = "2";
//        String tax = "2";
//        String total = "14";
//        OrderProduct orderProduct = new OrderProduct(product,subtotal,shipping,tax,total);
//        List<Transaction> transactionList = paymentMethodService.getTransactionInformation(orderProduct);
//        if (transactionList == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(transactionList, HttpStatus.OK);
//    }

    @RequestMapping(value = "/authorize_payment", method = RequestMethod.POST)
    public ResponseEntity<String> authorizePayment() throws PayPalRESTException {
        String approvalLink = paymentMethodService.authorizePayment();
        if (approvalLink == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(approvalLink, HttpStatus.OK);
    }

    @GetMapping("cancelUrl")
    public String cancelPay(){
        return "cancel.html";
    }

    @GetMapping("successUrl")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        try {
            Payment payment = paymentMethodService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }



}
