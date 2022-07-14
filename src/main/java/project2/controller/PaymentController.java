package project2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project2.dto.PaymentDTO;
import project2.model.*;
import project2.service.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/manager/payment/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    private IPaymentService iPaymentService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IPaymentMethodService iPaymentMethodService;

    @Autowired
    private ITransportService iTransportService;

    @Autowired
    private IMemberService iMemberService;

    @Autowired
    private ICartService iCartService;

    //QuangNV write method get product in cart
    @GetMapping("/getProduct/{idMember}")
    public ResponseEntity<List<Product>> getProductCart(@PathVariable Integer idMember){
        List<Product> productList = iProductService.getProductInCart(idMember);
        if (productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    //QuangNV write method save payment
    @PostMapping("/savePayment")
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody PaymentDTO paymentDTO, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            System.out.println("ss");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            Payment payment = new Payment();
            payment.setIdPayment(paymentDTO.getIdPayment());
            payment.setFullNameReceiver(paymentDTO.getFirstNameReceiver() + " " + paymentDTO.getLastNameReceiver());
            payment.setAddressReceiver(paymentDTO.getAddressReceiver() + ", " +paymentDTO.getWard() + ", " +paymentDTO.getDistrict() + ", " +paymentDTO.getCity());
            payment.setPhoneReceiver(paymentDTO.getPhoneReceiver());
            payment.setEmailReceiver(paymentDTO.getEmailReceiver());
            payment.setFeeService(paymentDTO.getFeeService());
            payment.setDescriptionReceiver(paymentDTO.getDescriptionReceiver());
            payment.setPaymentMethod(paymentDTO.getPaymentMethod());
            payment.setMember(paymentDTO.getMember());
            payment.setTransport(paymentDTO.getTransport());
            payment.setCart(paymentDTO.getCart());
            System.out.println(payment);
            return new ResponseEntity<>(iPaymentService.save(payment), HttpStatus.OK);
        }
    }

    //QuangNV write method get all payment
    @GetMapping("/getPayment")
    public ResponseEntity<List<Payment>> getAllPayment(){
        List<Payment> paymentList = iPaymentService.getAllPayment();
        if (paymentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(paymentList, HttpStatus.OK);
        }
    }

    //QuangNV write method get all paymentMethod
    @GetMapping("/getPaymentMethod")
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethod(){
        List<PaymentMethod> paymentMethodList = iPaymentMethodService.getAll();
        if (paymentMethodList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(paymentMethodList, HttpStatus.OK);
    }

    //QuangNV write method get all transport
    @GetMapping("/getTransport")
    public ResponseEntity<List<Transport>> getAllTransport(){
        List<Transport> transportList = iTransportService.getAll();
        if (transportList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(transportList, HttpStatus.OK);
        }
    }

    //QuangNV write method get all member
    @GetMapping("/getMember/{id_member}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id_member){
        Member member = iMemberService.findById(id_member);
        if (member ==  null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
    }

    //QuangNV write method get Cart by ID member
    @GetMapping("/getCart/{id_member}")
    public ResponseEntity<Cart> getCart(@PathVariable String id_member){
        Long id_member1 = Long.parseLong(id_member);
        Cart cart = iCartService.findByIdMember(id_member1);
        if (cart == null){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
    }
}
