package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Account;
import project2.repository.IAccountRepository;
import project2.service.IAccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Iterable<Account> saveAll(Iterable<Account> accounts) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
    @Override
    public void delele(Account account) {

    }

    /* Get accounts by role name -TuanNHA */
    @Override
    public List<Account> getAccountsByRoleName(String roleName) {
        return this.accountRepository.getAccountsByRole(roleName);
    }

    /* Get account by username -TuanNHA*/
    @Override
    public Optional<Account> getAccountByUsername(String username) {
        return this.accountRepository.getAccountByUsername(username);
    }
}
