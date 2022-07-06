package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Rank;

public interface IRankRepository extends JpaRepository<Rank, Long> {
}
