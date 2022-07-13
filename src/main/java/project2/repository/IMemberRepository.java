package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Member;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {

    //SonLT View-Member
    Member findMemberByAccount_IdAccount(Long id);
}
