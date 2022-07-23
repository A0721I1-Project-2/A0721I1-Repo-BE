package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.ImageProduct;
import project2.model.Product;
import project2.repository.IImageProductRepository;
import project2.service.IImageProductService;

import java.util.List;

@Service
public class ImageProductService implements IImageProductService {
    @Autowired
    private IImageProductRepository iImageProductRepository;

    @Override

    public List<ImageProduct> findByAll() {
        return iImageProductRepository.findAll();
    }

    public List<ImageProduct> findByProduct(Product product) {
        return iImageProductRepository.findByProduct(product);
    }
}
