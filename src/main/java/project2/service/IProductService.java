package project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import project2.model.Product;
import project2.repository.IProductRepository;

import java.util.List;

public interface IProductService {
    List<Product> getAllProductByEndDate(String statsBegin, String statsEnd,int biddingStatus);
    List<Product> getAllProductAtCurrentMonth(int curMonth,int biddingStatus);
}
