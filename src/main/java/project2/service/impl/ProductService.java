package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.dto.TransactionDTO;
import project2.model.Product;
import project2.repository.IProductRepository;
import project2.service.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
//
////    @Override
////    public String getNameProduct() {
////        return productRepository.getNameProduct();
////    }
//
//    public List<TransactionDTO> getAllTransaction() {
//        return productRepository.findAll()
//                .stream()
//                .map(this::convert)
//                .collect(Collectors.toList());
//    }
//
//    private TransactionDTO convert(Product product) {
//        TransactionDTO transactionDTO = new TransactionDTO();
//        transactionDTO.setProductName(product.getNameProduct());
//        transactionDTO.setFinalBidPrice(product.getFinalPrice());
//        transactionDTO.setSuccessfulBiddingTime(product.getEndDate());
//        return transactionDTO;
//    }
}
