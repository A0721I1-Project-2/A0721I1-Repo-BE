package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Member;

import java.util.Optional;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {
    /* Get member by account id */
    @Query(value = "select * from member where member.id_account = ?1" , nativeQuery = true)
    Optional<Member> getMemberByAccountId(Long id);
}
