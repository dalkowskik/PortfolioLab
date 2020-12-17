package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entities.Institution;

import java.util.Optional;

public interface InstitutionRepo extends JpaRepository<Institution, Long> {

    Institution findByName(String name);

   void deleteById(long id);
}
