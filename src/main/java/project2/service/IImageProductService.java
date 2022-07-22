package project2.service;

import project2.model.ImageProduct;
import project2.model.TypeProduct;

import java.util.List;

public interface IImageProductService {
    List<ImageProduct> findByAll();
}
