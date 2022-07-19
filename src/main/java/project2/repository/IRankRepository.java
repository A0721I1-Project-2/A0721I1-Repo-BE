package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Rank;

@Repository
public interface IRankRepository extends JpaRepository<Rank, Long> {
}
