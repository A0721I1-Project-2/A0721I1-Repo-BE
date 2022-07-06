package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Transport;

public interface ITransportRepository extends JpaRepository<Transport, Long> {
}
