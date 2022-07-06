package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
