package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAllProductByEndDate(String statsBegin, String statsEnd)
    {
        return productRepository.findProductByEndDateAndBiddingStatus(statsBegin,statsEnd);
    }
}
