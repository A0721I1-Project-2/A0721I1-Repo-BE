package project2.service.impl;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public void saveForgotPassword(Account account, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        account.setPassword(encodedPassword);
        account.setToken(null);
        accountRepository.save(account);
    }

    @Override
    public void updateToken(Account account) {
        String token = RandomString.make(45);
        account.setToken(token);
        accountRepository.save(account);
    }

    @Override
    public Account findAccountByToken(String token) {
        return accountRepository.findAccountByToken(token);
    }

    @Override
    public Account findAccountByEmailAndUsername(String email, String username) {
        return accountRepository.findAccountByUsernameAndEnmail(username, email);
    }

}
