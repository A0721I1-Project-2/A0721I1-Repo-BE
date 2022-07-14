package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project2.model.Account;
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

    /* Get accounts by role name -TuanNHA */
    @Override
    public List<Account> getAccountsByRoleName(String roleName) {
        return this.accountRepository.getAccountsByRole(roleName);
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
