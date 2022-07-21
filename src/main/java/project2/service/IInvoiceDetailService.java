package project2.service;

import project2.model.ImageProduct;
import project2.model.InvoiceDetail;

import java.util.List;

public interface IInvoiceDetailService {
    List<InvoiceDetail> findAllStatusInvoice();

    void saveList(List<InvoiceDetail> invoiceDetailList);
//    List<ImageProduct> findAllImageProduct(int id);
}
