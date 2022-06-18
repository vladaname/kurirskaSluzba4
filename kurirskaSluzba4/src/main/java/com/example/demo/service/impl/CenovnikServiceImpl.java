package com.example.demo.service.impl;

import com.example.demo.dto.CenovnikDTO;
import com.example.demo.model.Cenovnik;
import com.example.demo.model.Osoba;
import com.example.demo.repository.CenovnikRepository;
import com.example.demo.repository.OsobaRepository;
import com.example.demo.service.CenovnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenovnikServiceImpl implements CenovnikService {

    @Autowired
    CenovnikRepository cenovnikRepository;

    @Override
    public Cenovnik createCenovnik(CenovnikDTO cenovnikDTO) {

            Cenovnik c = new Cenovnik();

            c.setCenaDo5kg(cenovnikDTO.getCenaDo5kg());
            c.setCenaOd5do10kg(cenovnikDTO.getCenaOd5do10kg());
            c.setCenaPreko10kg(cenovnikDTO.getCenaPreko10kg());

            cenovnikRepository.saveAndFlush(c);
            return c;

    }

    @Override
    public List<Cenovnik> listaCena() {
        return cenovnikRepository.findAll();
    }

//    @Override
//    public Cenovnik findTopByOrderByIdCenovnikDesc() {
//        return cenovnikRepository.findTopByOrderByIdCenovnikDesc();
//    }

    @Override
    public Cenovnik findTopByOrderByIdCenovnikDesc() {
        return cenovnikRepository.findTopByOrderByIdCenovnikDesc();
    }

}
