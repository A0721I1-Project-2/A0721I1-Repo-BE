package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.ApprovalStatus;

public interface IApprovalStatusRepository extends JpaRepository<ApprovalStatus, Long> {
}
