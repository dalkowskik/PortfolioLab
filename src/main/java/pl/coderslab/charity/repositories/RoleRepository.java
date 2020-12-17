package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entities.Role;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    Set<Role> findById(int id);

}
