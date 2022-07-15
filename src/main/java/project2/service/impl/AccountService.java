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

    private IAccountRepository iAccountRepository;

    @Override
    public Account save(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public Iterable<Account> saveAll(Iterable<Account> accounts) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return iAccountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }
    @Override
    public void delele(Account account) {

    }
}
