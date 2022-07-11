package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.PaymentMethod;
import project2.repository.IPaymentMethodRepository;
import project2.service.IPaymentMethodService;

import java.util.List;

@Service
public class PaymentMethodService implements IPaymentMethodService {
    @Autowired
    private IPaymentMethodRepository iPaymentMethodRepository;

    @Override
    public List<PaymentMethod> getAll() {
        return iPaymentMethodRepository.getAll();
    }
}
