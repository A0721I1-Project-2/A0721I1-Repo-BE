package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
