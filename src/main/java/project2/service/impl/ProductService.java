package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    //HieuDV
    @Override
    public Page<Product> getAllNotDeletedYet(Pageable pageable) {
        return iProductRepository.findAllNotDeletedYet(pageable);
    }

    //HieuDV
    @Override
    public List<Product> getAllNotDeletedYet() {
        return iProductRepository.findAllNotDeletedYet();
    }

    //HieuDV
    @Override
    public Page<Product> getAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus, Pageable pageable) {
        return iProductRepository.findAllProductByNameTypeSellerPriceStatus(name, typeProduct, sellerName, maxPrice, minPrice, BiddingStatus, pageable);
    }

    //HieuDV
    @Override
    public List<Product> getAllProductByNameTypeSellerPriceStatusNotPagination(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus) {
        return iProductRepository.findAllProductByNameTypeSellerPriceStatus(name, typeProduct, sellerName, maxPrice, minPrice, BiddingStatus);
    }

    //HieuDV
    @Override
    public Optional<Product> getProductByIdProduct(Long id) {
        return iProductRepository.findById(id);
    }

    //HieuDV
    @Override
    public void saveProduct(Product product) {
        iProductRepository.save(product);
    }
}
