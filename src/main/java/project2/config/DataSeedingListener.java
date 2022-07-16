package project2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import project2.model.Account;
import project2.model.Role;
import project2.repository.IAccountRepository;
import project2.repository.IRoleRepository;
import project2.ultil.EncrypPasswordUtils;

import java.util.HashSet;

/**
 * Seeding data test for table users and roles
 */
@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (roleRepository.findByName("ROLE_ADMIN")==null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER")==null){
            roleRepository.save(new Role("ROLE_MEMBER"));
        }

        /* Block */
        if (roleRepository.findByName("ROLE_BLOCK")==null){
            roleRepository.save(new Role("ROLE_BLOCK"));
        }

        /* Add admin */
        if (accountRepository.getAccountByUsername("admin@gmail.com") == null){
            Account admin = new Account();
            admin.setUsername("admin@gmail.com");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            accountRepository.save(admin);
        }

        /* Add member */
        if (accountRepository.getAccountByUsername("nguyenhanhtuan1206@gmail.com") == null){
            Account user = new Account();
            user.setUsername("nguyenhanhtuan1206@gmail.com");
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }

        /* Add member */
        if (accountRepository.getAccountByUsername("anhtuan@gmail.com") == null){
            Account user = new Account();
            user.setUsername("anhtuan@gmail.com");
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }

        /* Add member */
        if (accountRepository.getAccountByUsername("atuan@gmail.com") == null){
            Account user = new Account();
            user.setUsername("atuan@gmail.com");
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }
    }
}
