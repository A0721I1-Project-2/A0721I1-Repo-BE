package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

//    @Query(value=" select * from `product`\n" +
//            "        inner join imageproduct on imageproduct.id_product = `product`.id_product \n" +
//            "  where product.id_product=?1",nativeQuery=true)
//    Product findProductById(Long id_product);
}
