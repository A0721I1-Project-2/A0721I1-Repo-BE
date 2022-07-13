package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.ImageProduct;

@Repository
public interface IImageProductRepository extends JpaRepository<ImageProduct,Long> {
}
