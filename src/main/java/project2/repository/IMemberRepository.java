package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Member;

public interface IMemberRepository extends JpaRepository<Member, Long> {
}
