package project2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.dto.TransactionDTO;
import project2.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "select * from product \n" +
//            "\tinner join invoicedetail\t \n" +
//            "\ton invoicedetail.id_product = product.id_product\n" +
//            "\tinner join invoice \n" +
//            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
//            "    inner join payment\n" +
//            "    on invoice.id_payment = payment.id_payment\n" +
//            "\twhere (product.end_date between ?1 and ?2)" ,
//            countQuery =  "select * from product \n" +
//            "\tinner join invoicedetail\t \n" +
//            "\ton invoicedetail.id_product = product.id_product\n" +
//            "\tinner join invoice \n" +
//            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
//            "    inner join payment\n" +
//            "    on invoice.id_payment = payment.id_payment\n" +
//            "\twhere name_product like ?1 ", nativeQuery = true)
//    Page<Product> searchDate(Pageable pageable, String startDate, String endDate);
//
//    @Query(value = "select * from product \n" +
//            "\tinner join invoicedetail\t \n" +
//            "\ton invoicedetail.id_product = product.id_product\n" +
//            "\tinner join invoice \n" +
//            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
//            "    inner join payment\n" +
//            "    on invoice.id_payment = payment.id_payment\n" +
//            "\twhere name_product like ?1 ",
//            countQuery =  "select * from product \n" +
//                    "\tinner join invoicedetail\t \n" +
//                    "\ton invoicedetail.id_product = product.id_product\n" +
//                    "\tinner join invoice \n" +
//                    "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
//                    "    inner join payment\n" +
//                    "    on invoice.id_payment = payment.id_payment\n" +
//                    "\twhere name_product like ?1 ", nativeQuery = true)
//    Page<Product> findAllByNameProduct(Pageable pageable, String name);
//
//    @Query(value = "select invoice.id_invoice, status_invoice, name_member, final_price, initial_price, fee_service from product \n" +
//            "\tinner join invoicedetail\t \n" +
//            "\ton invoicedetail.id_product = product.id_product\n" +
//            "\tinner join invoice\n" +
//            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
//            "    inner join payment\n" +
//            "    on invoice.id_payment = payment.id_payment\n" +
//            "    inner join `member`\n" +
//            "    on invoice.id_member = `member`.id_member",
//            countQuery =  "select * from product \n" +
//            "\tinner join invoicedetail\t \n" +
//            "\ton invoicedetail.id_product = product.id_product\n" +
//            "\tinner join invoice \n" +
//            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
//            "    inner join payment\n" +
//            "    on invoice.id_payment = payment.id_payment\n" +
//            "\twhere name_product like ?1 ", nativeQuery = true)
//    Page<TransactionDTO> findAllTransaction

    @Query(value = "select invoice.id_invoice, status_invoice, name_member, final_price, initial_price, fee_service from product \n" +
            "\tinner join invoicedetail\t \n" +
            "\ton invoicedetail.id_product = product.id_product\n" +
            "\tinner join invoice\n" +
            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
            "    inner join payment\n" +
            "    on invoice.id_payment = payment.id_payment\n" +
            "    inner join `member`\n" +
            "    on invoice.id_member = `member`.id_member", nativeQuery = true)
    List<Product> findAllTransaction();
}
