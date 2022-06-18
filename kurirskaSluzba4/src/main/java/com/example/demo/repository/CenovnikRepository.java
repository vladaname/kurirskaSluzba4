package com.example.demo.repository;

import com.example.demo.model.Cenovnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CenovnikRepository extends JpaRepository<Cenovnik, Integer> {

//    List<Cenovnik> findAllById(int i);

 //   Cenovnik findTopByOrderByIdCenovnikDesc();

    Cenovnik findTopByOrderByIdCenovnikDesc();

}
