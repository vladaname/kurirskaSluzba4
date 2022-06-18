package com.example.demo.service;

import com.example.demo.dto.CenovnikDTO;
import com.example.demo.model.Cenovnik;

import java.util.List;

public interface CenovnikService {
    Cenovnik createCenovnik(CenovnikDTO cenovnikDTO);

    List<Cenovnik> listaCena();

 //   Cenovnik findTopByOrderByIdCenovnikDesc();

    Cenovnik findTopByOrderByIdCenovnikDesc();

    //   List<Cenovnik> getCenovnik(CenovnikDTO cenovnikDTO);
}
