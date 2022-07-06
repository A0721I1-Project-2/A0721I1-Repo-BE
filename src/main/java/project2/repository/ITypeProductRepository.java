package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.TypeProduct;

public interface ITypeProductRepository extends JpaRepository<TypeProduct, Long> {
}
