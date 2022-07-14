package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
