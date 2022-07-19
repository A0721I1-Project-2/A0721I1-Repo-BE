package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByNameRole(String roleName);
}
