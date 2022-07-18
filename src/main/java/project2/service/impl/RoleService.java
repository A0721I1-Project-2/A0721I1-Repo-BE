package project2.service.impl;

import org.springframework.stereotype.Service;
import project2.model.Account;
import project2.model.Role;
import project2.service.IRoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public Iterable<Role> saveAll(Iterable<Role> roles) {
        return null;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delele(Role role) {

    }
}
