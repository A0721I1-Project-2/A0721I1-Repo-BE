package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
