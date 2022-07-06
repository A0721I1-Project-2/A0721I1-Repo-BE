package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
