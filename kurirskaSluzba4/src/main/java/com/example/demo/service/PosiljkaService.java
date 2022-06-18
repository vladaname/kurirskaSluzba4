package com.example.demo.service;

import com.example.demo.dto.PosiljkaDTO;
import com.example.demo.model.Posiljka;
import com.example.demo.model.Racun;

import java.util.List;
import java.util.Map;

public interface PosiljkaService {
//    Posiljka createPosiljka(PosiljkaDTO posiljkaDTO, int idOsoba);

 //   Map.Entry<Posiljka, Integer> createPosiljka(PosiljkaDTO posiljkaDTO, int idOsoba);
    Racun createPosiljka(PosiljkaDTO posiljkaDTO, int idOsoba);

    List<Posiljka> getListaPisiljki(int idOsoba);

    List<Posiljka> getSvePosiljke();

    boolean promeniStatus(int idPosiljka);

    //   Posiljka getSifraPosiljke(int idOsoba);
}
