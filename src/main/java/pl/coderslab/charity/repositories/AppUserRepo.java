package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.entities.AppUser;
import pl.coderslab.charity.entities.Role;

import java.util.List;
import java.util.Set;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {


    List<AppUser> findAllByRoles(Set<Role> role);

}
