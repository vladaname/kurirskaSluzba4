package com.example.demo.service.impl;

import com.example.demo.model.Cenovnik;
import com.example.demo.model.Posiljka;
import com.example.demo.model.Racun;
import com.example.demo.repository.CenovnikRepository;
import com.example.demo.repository.PosiljkaRepository;
import com.example.demo.repository.RacunRepository;
import com.example.demo.service.RacunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RacunServiceImpl implements RacunService {

    @Autowired
    RacunRepository racunRepository;
    @Autowired
    CenovnikRepository cenovnikRepository;
    @Autowired
    PosiljkaRepository posiljkaRepository;


    
    @Override
    public Racun createRacun(int idOsoba) {


        return null;
    }
}
