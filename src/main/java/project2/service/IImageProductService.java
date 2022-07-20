package project2.service;

import project2.model.ImageProduct;
import project2.model.Product;

import java.util.List;

public interface IImageProductService {
    public List<ImageProduct> findByProduct(Product product);
}
