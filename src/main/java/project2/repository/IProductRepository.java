package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
