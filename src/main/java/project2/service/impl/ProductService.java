package project2.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.repository.IProductRepository;
import project2.service.IProductService;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public void getTransactionByProduct() {
        productRepository.getProductTransaction();
    }
}
