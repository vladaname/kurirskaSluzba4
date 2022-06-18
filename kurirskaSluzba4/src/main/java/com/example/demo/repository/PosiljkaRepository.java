package com.example.demo.repository;

import com.example.demo.model.Osoba;
import com.example.demo.model.Posiljka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PosiljkaRepository extends JpaRepository<Posiljka, Integer> {

    List<Posiljka> findAllByOsoba(Osoba o);

    List<Posiljka> findAllByStatusPosiljke(String dostava);

//    Posiljka findcenaOtkupa(int idOsoba);

//    Optional<Posiljka> getCenaOtkupaById(int idOsoba);

//    Optional<Posiljka> findPosiljkuZaOsobu(int idOsoba);


    //  @Query("select p.sifraPosiljke from Posiljka p where p.osoba.idOsoba =:prosledjenId");
  //  Posiljka findByOsobaId(@Param("prosledjenId") int idOsoba);


}
