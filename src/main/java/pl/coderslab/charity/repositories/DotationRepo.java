package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entities.Dotation;

public interface DotationRepo extends JpaRepository<Dotation, Long> {

    @Query(value = "select COUNT(id) as count from dotation", nativeQuery = true)
     Integer countId();

    @Query(value = "select SUM(quantity) from dotation", nativeQuery = true)
    Integer sumQuantity();







}
