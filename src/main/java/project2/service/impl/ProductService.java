package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Optional<Product> getProductById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void updateCurrentPrice(Product product) {
        iProductRepository.save(product);
    }
}
