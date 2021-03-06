package project2.service;

import project2.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService{
    Account save(Account account);

    Iterable<Account> saveAll(Iterable<Account> accounts);

    Optional<Account> findById(Long id);

    List<Account> findAll();

    void deleteById(Long id);

    void delele(Account account);

}
