package project2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllNotDeleted();
    Page<Product> findAllNotDeleted(Pageable pageable);
    Product findProductByIdProduct(Long id);
    List<Product> findAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName,Double maxPrice,Double minPrice, String status);
    Page<Product> findAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName,Double maxPrice,Double minPrice, String status, Pageable pageable);
}
