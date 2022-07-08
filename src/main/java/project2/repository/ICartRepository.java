package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
