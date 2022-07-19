package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project2.model.Account;
import project2.model.Member;
import project2.model.Role;
import project2.repository.IAccountRepository;
import project2.service.IAccountService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService implements IAccountService,UserDetailsService {
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

    // HuyNN
    @Override
    public Account findByMember(Member member) {
        return accountRepository.findByMember(member);
    }

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


    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("user not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = account.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNameRole()));
        }
        return new org.springframework.security.core.userdetails.User(
                account.getUsername(), account.getPassword(), grantedAuthorities
        );
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername(username);
    }
}
