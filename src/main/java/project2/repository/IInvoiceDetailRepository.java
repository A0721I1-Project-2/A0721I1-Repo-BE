package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.InvoiceDetail;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
