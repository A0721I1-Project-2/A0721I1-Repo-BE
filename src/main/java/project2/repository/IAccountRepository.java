package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Account;
import project2.model.Member;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByMember(Member member);
}
