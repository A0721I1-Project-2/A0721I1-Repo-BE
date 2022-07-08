package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select name_product, initial_price, final_price, end_date from Product", nativeQuery = true)
    void getProductTransaction();
}
