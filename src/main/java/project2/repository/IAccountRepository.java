package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Account;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    /* Get account by username */
    @Query(value = "select * from account where `account`.username = ?1" , nativeQuery = true)
    Optional<Account> getAccountByUsername(String username);
}
