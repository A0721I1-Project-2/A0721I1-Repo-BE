package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.BiddingStatus;

public interface IBiddingStatusRepository extends JpaRepository<BiddingStatus, Long> {
}
