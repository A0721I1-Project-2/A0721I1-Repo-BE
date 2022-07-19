package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.ApprovalStatus;

@Repository
public interface IApprovalStatusRepository extends JpaRepository<ApprovalStatus, Long> {
}
