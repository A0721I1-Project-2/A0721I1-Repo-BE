package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Invoice;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
}
