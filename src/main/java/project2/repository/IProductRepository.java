package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product " +
            "join product_member on product_member.id_product = product.id_product " +
            "join member on member.id_member = product_member.id_member " +
            "where product.id_product =?1",nativeQuery = true)
    Product findproductById(long id);
}
