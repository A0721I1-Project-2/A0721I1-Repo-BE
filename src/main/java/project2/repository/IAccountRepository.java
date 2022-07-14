package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Account;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    /* Get accounts by role name -TuanNHA */
    @Query(value = "select * from `account` \n" +
            "inner join `account_role`\n" +
            "on `account_role`.id_account = `account_role`.id_account\n" +
            "inner join `role`\n" +
            "on `role`.id_role = `account_role`.id_role\n" +
            "where `role`.name_role = ?1 \n" +
            "group by `account`.id_account" , nativeQuery=true)
    List<Account> getAccountsByRole(String nameRole);

    Account findAccountByUsername(String username);

    Account getAccountByUsername(String username);
}
