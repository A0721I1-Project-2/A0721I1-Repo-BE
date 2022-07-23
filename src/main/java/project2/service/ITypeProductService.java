package project2.service;

import project2.model.TypeProduct;

import java.util.List;

public interface ITypeProductService {

    TypeProduct findById(Long id);

    List<TypeProduct> findByAll();

}
