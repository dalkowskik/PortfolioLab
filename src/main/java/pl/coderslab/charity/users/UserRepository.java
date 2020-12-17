package pl.coderslab.charity.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.entities.AppUser;

import java.util.List;


public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmailAndPassword(String email, String password);

    @Query(value = "select a from AppUser as a where a.username=':name'")
    List<AppUser> someUser(@Param("name") String name);

    AppUser findByEmail(String email);

    AppUser findByUsername(String username);

}
