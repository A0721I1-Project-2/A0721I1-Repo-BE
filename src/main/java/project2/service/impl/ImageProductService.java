package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.ImageProduct;
<<<<<<< HEAD
=======
import project2.model.Product;
>>>>>>> origin/dev
import project2.repository.IImageProductRepository;
import project2.service.IImageProductService;

import java.util.List;

@Service
public class ImageProductService implements IImageProductService {
    @Autowired
    private IImageProductRepository iImageProductRepository;

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public ImageProduct save(ImageProduct imageProduct) {
        return iImageProductRepository.save(imageProduct);
=======
=======
    public ImageProduct save(ImageProduct imageProduct) {
        return iImageProductRepository.save(imageProduct);
    }

    @Override
>>>>>>> ba45e67be83e3e23bc85fa933ae87c535cbf7fa4
    public List<ImageProduct> findByProduct(Product product) {
        return iImageProductRepository.findByProduct(product);
>>>>>>> origin/dev
    }
}
