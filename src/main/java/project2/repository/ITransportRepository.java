package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Transport;

@Repository
public interface ITransportRepository extends JpaRepository<Transport, Long> {
}
