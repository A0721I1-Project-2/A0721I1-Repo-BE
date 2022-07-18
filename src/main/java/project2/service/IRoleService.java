package project2.service;

import project2.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role save(Role role);

    Iterable<Role> saveAll(Iterable<Role> roles);

    Optional<Role> findById(Long id);

    List<Role> findAll();

    void deleteById(Long id);

    void delele(Role role);
}
