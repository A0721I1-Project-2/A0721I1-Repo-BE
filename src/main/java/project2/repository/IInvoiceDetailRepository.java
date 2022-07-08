package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.InvoiceDetail;

@Repository
public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
