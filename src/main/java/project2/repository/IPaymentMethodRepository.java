package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.PaymentMethod;

public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
