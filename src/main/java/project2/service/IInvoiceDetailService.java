package project2.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project2.model.InvoiceDetail;

public interface IInvoiceDetailService {

    Page<InvoiceDetail> getAll(Pageable pageable);
}
