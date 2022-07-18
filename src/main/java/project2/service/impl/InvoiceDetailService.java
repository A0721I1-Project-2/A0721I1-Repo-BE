package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project2.model.InvoiceDetail;
import project2.repository.IInvoiceDetailRepository;
import project2.service.IInvoiceDetailService;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {

    @Autowired
    IInvoiceDetailRepository iInvoiceDetailRepository;

    @Override
    public Page<InvoiceDetail> getAll(Pageable pageable) {
        return iInvoiceDetailRepository.findAll(pageable);
    }
}
