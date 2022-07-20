package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import project2.config.SmtpAuthenticator;
import project2.dto.AuctionDTO;
import project2.model.ImageProduct;
import project2.model.Product;
import project2.service.IImageProductService;
import project2.service.IProductService;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/manager/product/api")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IImageProductService iImageProductService;

    @Autowired
    private SmtpAuthenticator smtpAuthenticator;


    //HuyNN
    Map<Long, List<AuctionDTO>> auctionList = new HashMap<>();

    //HuyNN
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id).get(), HttpStatus.OK);
    }

    //HuyNN
    @PostMapping("/createNewAuction/{productId}")
    public ResponseEntity createNewAuction(@RequestBody AuctionDTO auctionDTO, @PathVariable Long productId) {
        if (this.auctionList.containsKey(productId)) {
            List<AuctionDTO> auctionDTOList = this.auctionList.get(productId);
            auctionDTOList.add(0, auctionDTO);
            this.auctionList.put(productId, auctionDTOList);
            this.updateCurrentPrice(productId, auctionDTO.getPrice());
            return new ResponseEntity(auctionDTOList, HttpStatus.OK);
        } else {
            List<AuctionDTO> auctionDTOList = new ArrayList<>();
            auctionDTOList.add(auctionDTO);
            auctionList.put(productId, auctionDTOList);
            this.updateCurrentPrice(productId, auctionDTO.getPrice());
            return new ResponseEntity(this.auctionList, HttpStatus.OK);
        }
    }

    //HuyNN
    public void updateCurrentPrice(Long productId, Double price) {
        Product product = productService.getProductById(productId).get();
        product.setFinalPrice(price);
        productService.updateCurrentPrice(product);
    }

    //HuyNN
    @GetMapping("/getAuctionList/{productId}")
    public ResponseEntity getAuctionList(@PathVariable Long productId) {
        if (this.auctionList.containsKey(productId)) {
            List<AuctionDTO> auctionDTOList = this.auctionList.get(productId);
            return new ResponseEntity(auctionDTOList, HttpStatus.OK);
        } else {
            List<AuctionDTO> auctionDTOList = new ArrayList<>();
            auctionList.put(productId, auctionDTOList);
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }

    //HuyNN
    @GetMapping("/checkPaymentAuctionProduct")
    public ResponseEntity checkPaymentAuctionProduct() {
        sendEmailAuctionProduct("test", "test", "test");
        return new ResponseEntity(null, HttpStatus.OK);
    }

    //HuyNN
    @GetMapping("/getImageByProductId/{id}")
    public ResponseEntity<List<ImageProduct>> getImageByProductId(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        return new ResponseEntity<List<ImageProduct>>(iImageProductService.findByProduct(product), HttpStatus.OK);
    }

    //HuyNN
    public void sendEmailAuctionProduct(String email, String productName, String productImage) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.stmp.user", "a0721i1.2022@gmail.com");

        //To use TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", "ykddrsefedbcbvos");
        //To use SSL
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, smtpAuthenticator);
        String to = "nguyennhathuy.cd@gmail.com";
        String from = "contact@a0721i1.com";
        String subject = "Successfully auctioned the product Samsung S22";
        MimeMessage msg = new MimeMessage(session);
        MimeMessageHelper helper = new MimeMessageHelper(msg, "UTF-8");

        try {
            helper.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            helper.setSubject(subject);
            String content = "<table width='100%' border='0' cellspacing='0' cellpadding='0' bgcolor='#f4f4f4' class='gwfw'>\n" +
                    "    <tr>\n" +
                    "        <td align='center' valign='top'>\n" +
                    "            <!-- Header -->\n" +
                    "            <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                <tr>\n" +
                    "                    <td style='padding: 55px 10px 30px 10px;' class='p30-20' align='center'>\n" +
                    "                        <table width='650' border='0' cellspacing='0' cellpadding='0' class='m-shell'>\n" +
                    "                            <tr>\n" +
                    "                                <td class='td' style='width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;'>\n" +
                    "                                    <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                        <tr>\n" +
                    "                                            <td class='logo img' style='font-size:0pt; line-height:0pt; text-align:left;'><img src='images/logo.jpg' width='206' height='30' editable='true' border='0' alt='' /></td>\n" +
                    "                                            <td align='right' width='100'>\n" +
                    "                                                <table border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                    <tr>\n" +
                    "                                                        <td class='text-top' style='color:#999999; font-family:'Roboto', Arial, sans-serif; font-size:13px; line-height:18px; text-align:right; min-width:auto !important;'><multiline><webversion class='link-grey-u' style='color:#999999; text-decoration:underline;'>view online</webversion></multiline></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                    </table>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                        </table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "            </table>\n" +
                    "            <!-- END Header -->\n" +
                    "            \n" +
                    "            <!-- Footer -->\n" +
                    "            <table width='100%' border='0' cellspacing='0' cellpadding='0' bgcolor='#a63434'>\n" +
                    "                <tr>\n" +
                    "                    <td align='center' style='padding: 60px 0px 50px 0px;' class='p30-20'>\n" +
                    "                        <table width='650' border='0' cellspacing='0' cellpadding='0' class='m-shell'>\n" +
                    "                            <tr>\n" +
                    "                                <td class='td' style='width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;'>\n" +
                    "                                    <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                        <tr>\n" +
                    "                                            <td style='padding-bottom: 32px;'>\n" +
                    "                                                <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                    <tr>\n" +
                    "                                                        <th class='column' width='150' style='font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;'>\n" +
                    "                                                            <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                                <tr>\n" +
                    "                                                                    <td class='img m-center' style='font-size:0pt; line-height:0pt; text-align:left;'><img src='images/footer_logo.jpg' width='207' height='30' editable='true' border='0' alt='' /></td>\n" +
                    "                                                                </tr>\n" +
                    "                                                            </table>\n" +
                    "                                                        </th>\n" +
                    "                                                        <th style='padding-bottom: 25px !important; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;' class='column' width='1'></th>\n" +
                    "                                                        <th class='column' style='font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;'>\n" +
                    "                                                            <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                                <tr>\n" +
                    "                                                                    <td align='right'>\n" +
                    "                                                                        <table class='center' border='0' cellspacing='0' cellpadding='0' style='text-align:center;'>\n" +
                    "                                                                            <tr>\n" +
                    "                                                                                <td class='img' width='55' style='font-size:0pt; line-height:0pt; text-align:left;'><img src='images/ico_facebook.jpg' width='34' height='34' editable='true' border='0' alt='' /></td>\n" +
                    "                                                                                <td class='img' width='55' style='font-size:0pt; line-height:0pt; text-align:left;'><img src='images/ico_twitter.jpg' width='34' height='34' editable='true' border='0' alt='' /></td>\n" +
                    "                                                                                <td class='img' width='55' style='font-size:0pt; line-height:0pt; text-align:left;'><img src='images/ico_instagram.jpg' width='34' height='34' editable='true' border='0' alt='' /></td>\n" +
                    "                                                                                <td class='img' width='34' style='font-size:0pt; line-height:0pt; text-align:left;'><img src='images/ico_linkedin.jpg' width='34' height='34' editable='true' border='0' alt='' /></td>\n" +
                    "                                                                            </tr>\n" +
                    "                                                                        </table>\n" +
                    "                                                                    </td>\n" +
                    "                                                                </tr>\n" +
                    "                                                            </table>\n" +
                    "                                                        </th>\n" +
                    "                                                    </tr>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        <tr>\n" +
                    "                                            <td>\n" +
                    "                                                <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                    <tr>\n" +
                    "                                                        <th class='column-top' width='370' style='font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; vertical-align:top;'>\n" +
                    "                                                            <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                                <tr>\n" +
                    "                                                                    <td class='text-footer m-center' style='color:#ffffff; font-family:'Roboto', Arial, sans-serif; font-size:12px; line-height:26px; text-align:left; min-width:auto !important;'><multiline>LuxuryEstates - Free HTML Email Template<br /> East Pixel Bld. 99, Creative City 9000, Republic of Design</multiline></td>\n" +
                    "                                                                </tr>\n" +
                    "                                                            </table>\n" +
                    "                                                        </th>\n" +
                    "                                                        <th style='padding-bottom: 25px !important; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;' class='column' width='1'></th>\n" +
                    "                                                        <th class='column-bottom' style='font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; vertical-align:bottom;'>\n" +
                    "                                                            <table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
                    "                                                                <tr>\n" +
                    "                                                                    <td class='text-footer right m-center' style='color:#ffffff; font-family:'Roboto', Arial, sans-serif; font-size:12px; line-height:26px; min-width:auto !important; text-align:right;'><unsubscribe class='link-white-u' style='color:#ffffff; text-decoration:underline;'>Unsubscribe</unsubscribe></td>\n" +
                    "                                                                </tr>\n" +
                    "                                                            </table>\n" +
                    "                                                        </th>\n" +
                    "                                                    </tr>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                    </table>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                        </table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "            </table>\n" +
                    "            <!-- END Footer -->\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "</table>";
            helper.setText(content, true);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", 465, "a0721i1.2022@gmail.com", "ykddrsefedbcbvos");
            transport.send(msg);
            System.out.println("fine!!");
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    //VinhTQ
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> findProductByIdForProductDetail(@PathVariable() long id) {
        return new ResponseEntity<Product>(productService.findProductByIdForProductDetail(id), HttpStatus.OK);
    }
    //VinhTQ
    @GetMapping("/highest-bidder/{id}")
    public ResponseEntity<Product> finForProductDetail(@PathVariable() long id) {
        return new ResponseEntity<Product>(productService.findProductByIdForProductDetail(id), HttpStatus.OK);
    }

    //HauLST
    @GetMapping("/list/auction")
    public ResponseEntity<List<Product>> showListProductAuction() {
        List<Product> productList = productService.getAllProductAuntion();

        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        } else {
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }


    // HauLST
    @GetMapping("/list/finished-auction")
    public ResponseEntity<List<Product>> showListProductFinishedAuction() {
        List<Product> productList = productService.getAllProductFinishedAuntion();
        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    //HauLST
    @GetMapping("/list/auction/{typeProduct}")
    public ResponseEntity<List<Product>> showListProductAuctionAndTypeProduct(@PathVariable String typeProduct) {
        List<Product> productList = productService.gettAllProductAuntionAndTypeProduct(typeProduct);
        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    //HauLST
    @GetMapping("list/search/name={nameProduct}/type-product={typeProduct}/{min}/{max}")
    public ResponseEntity<List<Product>> searchNameAndTypeAndPrices(@PathVariable String nameProduct, @PathVariable String typeProduct, @PathVariable Double min, @PathVariable Double max) {
        List<Product> productList = productService.searchProductByNameByTypeProductByPrice(nameProduct, typeProduct, min, max);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //HauLST 
    @GetMapping("list/search/name={nameProduct}/type-product={typeProduct}/{min}")
    public ResponseEntity<List<Product>> searchPricesOver250(@PathVariable String nameProduct, @PathVariable String typeProduct, @PathVariable Double min) {
        List<Product> productList = productService.searchProductPricesOver250(nameProduct, typeProduct, min);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}

