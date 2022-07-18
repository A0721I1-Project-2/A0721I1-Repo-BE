package project2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.InvoiceDetail;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {

    @Query(value = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service from product \n" +
            "\tinner join invoicedetail\t \n" +
            "\ton invoicedetail.id_product = product.id_product\n" +
            "\tinner join invoice\n" +
            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
            "    inner join payment\n" +
            "    on invoice.id_payment = payment.id_payment\n" +
            "    inner join `member`\n" +
            "    on invoice.id_member = `member`.id_member " +
            "where invoice.flag_delete = 0;", nativeQuery = true)
    List<InvoiceDetail> findAllTransactionNotPagination();

    @Query(value = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service from product \n" +
            "\tinner join invoicedetail\t \n" +
            "\ton invoicedetail.id_product = product.id_product\n" +
            "\tinner join invoice\n" +
            "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
            "    inner join payment\n" +
            "    on invoice.id_payment = payment.id_payment\n" +
            "    inner join `member`\n" +
            "    on invoice.id_member = `member`.id_member " +
            "where invoice.flag_delete = 0",
            countQuery = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service from product \n" +
                    "\tinner join invoicedetail\t \n" +
                    "\ton invoicedetail.id_product = product.id_product\n" +
                    "\tinner join invoice\n" +
                    "\ton invoice.id_invoice = invoicedetail.id_invoice\n" +
                    "    inner join payment\n" +
                    "    on invoice.id_payment = payment.id_payment\n" +
                    "    inner join `member`\n" +
                    "    on invoice.id_member = `member`.id_member " +
                    "where invoice.flag_delete = 0;", nativeQuery = true)
    Page<InvoiceDetail> findAllTransaction(Pageable pageable);

    @Query(value = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service  from product  " +
            "            inner join `invoicedetail` " +
            "            on `invoicedetail`.id_product = product.id_product " +
            "            inner join `invoice` " +
            "            on `invoice`.id_invoice = `invoicedetail`.id_invoice " +
            "            inner join `payment` " +
            "            on `invoice`.id_payment = `payment`.id_payment " +
            "            inner join `member` " +
            "            on `invoice`.id_member = `member`.id_member " +
            "            where `invoice`.flag_delete = 0 " +
            "            and name_member like concat('%', ?1, '%')" +
            "            and full_name_receiver like concat('%', ?2, '%')" +
            "            and name_product like concat('%', ?3, '%') " +
            "            and invoice.status_invoice = ?4",
            countQuery = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service  from product  " +
            "            inner join `invoicedetail` " +
            "            on `invoicedetail`.id_product = product.id_product " +
            "            inner join `invoice` " +
            "            on `invoice`.id_invoice = `invoicedetail`.id_invoice " +
            "            inner join `payment` " +
            "            on `invoice`.id_payment = `payment`.id_payment " +
            "            inner join `member` " +
            "            on `invoice`.id_member = `member`.id_member " +
            "            where `invoice`.flag_delete = 0 " +
            "            and name_member like concat('%', ?1, '%')" +
            "            and full_name_receiver like concat('%', ?2, '%')" +
            "            and name_product like concat('%', ?3, '%') " +
                    "    and invoice.status_invoice = ?4", nativeQuery = true)
    Page<InvoiceDetail> searchTransaction(String nameSeller, String nameBuyer, String nameProduct, String status, Pageable pageable);

    @Query(value = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service from product " +
            "            inner join invoicedetail " +
            "            on invoicedetail.id_product = product.id_product " +
            "            inner join invoice " +
            "            on invoice.id_invoice = invoicedetail.id_invoice " +
            "            inner join payment " +
            "            on invoice.id_payment = payment.id_payment " +
            "            inner join `member` " +
            "            on invoice.id_member = `member`.id_member " +
            "            where invoice.flag_delete = 0 " +
            "            and product.end_date between ?1 and ?2 " ,
            countQuery = "select invoice.id_invoice, end_date, invoicedetail.id_invoice_detail, invoice.flag_delete, payment.full_name_receiver, invoice.id_payment, invoice.id_member, invoicedetail.id_product, invoice.status_invoice, `member`.name_member,final_price, initial_price, payment.fee_service from product\n" +
                    "            inner join invoicedetail " +
                    "            on invoicedetail.id_product = product.id_product " +
                    "            inner join invoice\n" +
                    "            on invoice.id_invoice = invoicedetail.id_invoice " +
                    "            inner join payment " +
                    "            on invoice.id_payment = payment.id_payment " +
                    "            inner join `member` " +
                    "            on invoice.id_member = `member`.id_member " +
                    "            where invoice.flag_delete = 0 " +
                    "            and product.end_date between ?1 and ?2 ", nativeQuery = true)
    Page<InvoiceDetail> searchDate(String startDate, String endDate, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `project2`.`invoice` SET `invoice`.flag_delete = true WHERE (`invoice`.id_invoice = ?1);", nativeQuery = true)
    void setStatus(Long id);
}
