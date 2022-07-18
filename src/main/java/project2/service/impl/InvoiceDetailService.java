package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.ImageProduct;
import project2.model.InvoiceDetail;
import project2.repository.IInvoiceDetailRepository;
import project2.service.IInvoiceDetailService;

import java.util.List;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {
    @Autowired
    private IInvoiceDetailRepository iInvoiceDetailRepository;

    @Override
    public List<InvoiceDetail> findAllStatusInvoice()  {
        return iInvoiceDetailRepository.findAllStatusInvoice();
    }

//    @Override
//    public List<ImageProduct> findAllImageProduct(int id) {
//        return iInvoiceDetailRepository.findAllImg(id);
//    }

}
