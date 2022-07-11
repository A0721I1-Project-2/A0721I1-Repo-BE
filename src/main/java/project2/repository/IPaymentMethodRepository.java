package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.PaymentMethod;

import java.util.List;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    @Query(value = "select * from `PaymentMethod`", nativeQuery = true)
    List<PaymentMethod> getAll();
}
