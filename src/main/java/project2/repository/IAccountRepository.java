package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Account;
import project2.model.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
<<<<<<< HEAD
    /* Get account by username */
    @Query(value = "select * from `account` where `account`.`username` = ?1" , nativeQuery = true)
    Account getAccByUsername(String username);


    /* Get accounts by role name -TuanNHA */
    @Query(value = "select * from `account` \n" +
            "inner join account_role\n" +
            "on account_role.id_account = `account`.id_account\n" +
            "group by `account`.id_account\n" +
            "having count(account_role.id_role) = 1" , nativeQuery=true)
    List<Account> getAccountsByRoleMember();
=======
    Account findByMember(Member member);

    //    @Query(value = "select * from account where toke = ?1",nativeQuery = true)
    Account findAccountByToken(String token);

    @Query(value = "select * from account \n" +
            "join member on member.id_account = account.id_account\n" +
            "where account.username = ?1 and member.email_member = ?2",nativeQuery = true)
    Account findAccountByUsernameAndEnmail(String username, String email);
>>>>>>> 5790b7296bb0ec9547291a7bd978446ecc1896b3

    Account findAccountByUsername(String username);

    Account getAccountByUsername(String username);
}
