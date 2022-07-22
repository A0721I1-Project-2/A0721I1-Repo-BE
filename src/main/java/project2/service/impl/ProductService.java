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
    public Product getProductById(Long id_product) {
        return iProductRepository.findById(id_product).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
          return iProductRepository.save(product);
    }
}
