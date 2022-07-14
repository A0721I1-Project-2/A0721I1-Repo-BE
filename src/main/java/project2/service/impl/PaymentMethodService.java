package project2.service.impl;


import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.OrderProduct;
import project2.model.PaymentMethod;
import project2.repository.IPaymentMethodRepository;
import project2.service.IPaymentMethodService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService implements IPaymentMethodService {
    //SELLER INFOR
    private static final String CLIENT_ID = "ARDVlALPHdMzIMrlMUAYuqBWDR6RizGTvzWpaVtU8oe34mTrYVecThSFVIheQyYY3H_k6MCn3S_0p4QA";
    private static final String CLIENT_SECRET = "EEAQm74YoZxBbqFX_oitOeuwmTNdzuYf9IygTgh3dZPAMNX4EGXFdK5wHqBEWWn7xI28LghuKYSHnnci";
    private static final String MODE = "sandbox";

    //RESPONSE URL CANCEL & SUCCESS AFTER BUYER PAYMENT
    private static final String URL_CANCEL = "http://localhost:8080/payment/cancelUrl";
    private static final String URL_SUCCSESS = "http://localhost:8080/payment/successUrl";

    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;


    @Override
    public List<PaymentMethod> getAllPaymentMethod() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public Optional<PaymentMethod> getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    //I : SEND TO PAYPAL ABOUT PAYER, TRANSACTION; O : RESPONSE URL FROM CHECKOUT
    @Override
    public String authorizePayment() throws PayPalRESTException {
        Payer payer = getPayerInformation();
        String product = "test1";
        String subtotal = "10";
        String shipping = "2";
        String tax = "2";
        String total = "14";
        OrderProduct orderProduct = new OrderProduct(product,subtotal,shipping,tax,total);
        List<Transaction> transactionList = getTransactionInformation(orderProduct);
        RedirectUrls redirectUrls = getRedirectURLs();
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(transactionList)
                .setRedirectUrls(redirectUrls)
                .setPayer(payer)
                //.setIntent("authorize"); //authorize : ủy quyền tạm giữ 29 ngày or đến khi hoàn thành giao dịch
                .setIntent("sale"); //capture : thu tiền ngay lập tức từ người mua
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = requestPayment.create(apiContext);
        System.out.println(approvedPayment);
        return getApprovalLink(approvedPayment);
    }
    //USE TO GET URL FORM PAYPAL
    private String getApprovalLink(Payment approvedPayment){
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
        for(Links link : links){
            if(link.getRel().equals("approval_url")){
                approvalLink = link.getHref();
            }
        }
        return approvalLink;
    }

    public List<Transaction> getTransactionInformation(OrderProduct orderProduct){
        Details details = new Details();

        details.setShipping(orderProduct.getShipping());
//        details.setFee(String.format("%.2f", Float.parseFloat("2")));
        details.setSubtotal(orderProduct.getSubtotal());
        details.setTax(orderProduct.getTax());


        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(orderProduct.getTotal());
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderProduct.getProductName());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<Item>();

        Item item = new Item();
        item.setCurrency("USD")
                .setName(orderProduct.getProductName())
                .setPrice(orderProduct.getSubtotal())
                .setTax(orderProduct.getTax())
                .setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionList.add(transaction);

        return transactionList;
    }

    //USE TO SET URL REDIRECT
    public RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(URL_CANCEL);
        redirectUrls.setReturnUrl(URL_SUCCSESS);

        return redirectUrls;
    }
    //CHECK SUCCESS AND FAIL AFTER PAYMENTED
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return payment.execute(apiContext, paymentExecute);
    }

    @Override
    public Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("Kelvin")
                .setLastName("Nguyen")
                .setEmail("quang10a30504@gmail.com");
        payer.setPayerInfo(payerInfo);
        return payer;
    }

}
