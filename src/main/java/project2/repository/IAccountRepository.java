package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Account;
import project2.model.Member;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByMember(Member member);

    //    @Query(value = "select * from account where toke = ?1",nativeQuery = true)
    Account findAccountByToken(String token);

    @Query(value = "select * from account \n" +
            "join member on member.id_account = account.id_account\n" +
            "where account.username = ?1 and member.email_member = ?2",nativeQuery = true)
    Account findAccountByUsernameAndEnmail(String username, String email);

    Account findAccountByUsername(String username);

    Account getAccountByUsername(String username);
}
