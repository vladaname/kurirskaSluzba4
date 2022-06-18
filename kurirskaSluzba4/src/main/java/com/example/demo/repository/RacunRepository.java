package com.example.demo.repository;

import com.example.demo.model.Racun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface RacunRepository extends JpaRepository<Racun, Integer> {


}
