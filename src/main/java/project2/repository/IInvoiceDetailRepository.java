package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.InvoiceDetail;

import java.util.List;

@Repository
public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {

    //Nhung
    @Query(value ="SELECT   invoicedetail.id_invoice,invoice.date_created,paymentmethod.id_payment_method,transport.id_transport,imageproduct.id_product,invoicedetail.id_product ,invoice.id_payment, paymentmethod.name_payment_method,transport.name_transport,transport.fee_transport,invoicedetail.id_invoice_detail,payment.full_name_receiver,payment.phone_receiver,payment.email_receiver,payment.address_receiver,product.name_product,imageproduct.id_product,imageproduct.image_product,product.final_price " +
            "FROM invoicedetail inner JOIN invoice " +
            "ON invoicedetail.id_invoice = `invoice`.id_invoice " +
            "inner join payment " +
            "on invoice.id_payment=payment.id_payment " +
            "inner join paymentmethod " +
            "on payment.id_payment_method=paymentmethod.id_payment_method " +
            "inner join transport " +
            "on payment.id_transport=transport.id_transport " +
            "inner join product " +
            "on invoicedetail.id_product=product.id_product " +
            "inner join imageproduct " +
            "on product.id_product=imageproduct.id_product where payment.id_payment=1", nativeQuery = true)

    List<InvoiceDetail> findAllStatusInvoice();

    //Nhung
//    @Query(value="SELECT * from ImageProduct where id")
}
