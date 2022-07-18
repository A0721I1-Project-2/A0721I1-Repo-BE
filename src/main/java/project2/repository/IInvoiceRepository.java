package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Invoice;

import java.util.List;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
}
