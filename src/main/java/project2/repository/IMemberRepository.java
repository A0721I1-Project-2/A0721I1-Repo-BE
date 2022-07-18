package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Member;
@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select nameMember from Member")
    void getTransactionByMember();

}
