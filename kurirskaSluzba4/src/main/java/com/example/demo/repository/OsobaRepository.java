package com.example.demo.repository;

import com.example.demo.model.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface OsobaRepository extends JpaRepository<Osoba, Integer> {
    
    Osoba findByUsername(String username);


//    Optional<Osoba> findOsobaByUsername1();

//    @Query("select o from Osoba o where o.username =:username")
//    String findOsobaByUsername(@Param("username") String username);
}
