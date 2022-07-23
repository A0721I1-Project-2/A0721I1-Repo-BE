package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.TypeProduct;
import project2.repository.ITypeProductRepository;
import project2.service.ITypeProductService;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired
    private ITypeProductRepository typeProductRepository;
    @Override
    public List<TypeProduct> getAll() {
        return this.typeProductRepository.findAll();
    }
}
