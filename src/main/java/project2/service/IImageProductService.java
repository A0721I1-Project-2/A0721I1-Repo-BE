package project2.service;

import project2.model.ImageProduct;
import project2.model.Product;


import java.util.List;

public interface IImageProductService {

<<<<<<< HEAD
    ImageProduct save(ImageProduct imageProduct);

=======
    List<ImageProduct> findByAll();
>>>>>>> d7902aaa82febe4cd90244fc3eedd1eccc80223f
    public List<ImageProduct> findByProduct(Product product);

}
