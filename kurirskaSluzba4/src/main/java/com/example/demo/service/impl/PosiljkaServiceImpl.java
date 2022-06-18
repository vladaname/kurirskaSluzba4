package com.example.demo.service.impl;

import com.example.demo.dto.PosiljkaDTO;
import com.example.demo.model.Cenovnik;
import com.example.demo.model.Osoba;
import com.example.demo.model.Posiljka;
import com.example.demo.model.Racun;
import com.example.demo.repository.CenovnikRepository;
import com.example.demo.repository.OsobaRepository;
import com.example.demo.repository.PosiljkaRepository;
import com.example.demo.repository.RacunRepository;
import com.example.demo.service.PosiljkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PosiljkaServiceImpl implements PosiljkaService {

    @Autowired
    OsobaRepository osobaRepository;

    @Autowired
    PosiljkaRepository posiljkaRepository;
    @Autowired
    CenovnikRepository cenovnikRepository;
    @Autowired
    RacunRepository racunRepository;

    private static final String DOSTAVA = "dostava";
    private static final String DOSTAVLJENO = "dostavljeno";

    @Override
    //public Map.Entry<Posiljka, Integer> createPosiljka(PosiljkaDTO posiljkaDTO, int idOsoba) {
        public Racun createPosiljka(PosiljkaDTO posiljkaDTO, int idOsoba) {

            Posiljka p = new Posiljka();
            p.setStatusPosiljke(DOSTAVA);
            p.setAdresaDostave(posiljkaDTO.getAdresaDostave());
            p.setCenaOtkupa(posiljkaDTO.getCenaOtkupa());
            p.setTezina(posiljkaDTO.getTezina());
            p.setOpis(posiljkaDTO.getOpis());
//            Random r = new Random();
//            int randomInt = r.nextInt(10);
//            String sifraPosiljke = "RS" + randomInt;
//            p.setSifraPosiljke(sifraPosiljke);
            Date date = new Date();
            p.setVremeSlanja(date);
            p.setVremeDostave(date);
            long curentTime = date.getTime();
            int d = (int) curentTime * 1000;
            int dPositive = Math.abs(d);
            String sifra = Integer.toString(dPositive);
            String sifraFinal = "RS" + sifra;
            p.setSifraPosiljke(sifraFinal);


            Optional<Osoba> osoba = osobaRepository.findById(idOsoba);
            if(osoba.isPresent()){
                Osoba o = osoba.get();
                p.setOsoba(o);
            }
            else{
                return null;
            }
            posiljkaRepository.saveAndFlush(p);

            Racun r = new Racun();
            Cenovnik aktuelaniCenovnik = cenovnikRepository.findTopByOrderByIdCenovnikDesc();

            r.setCenovnik(aktuelaniCenovnik);
            r.setPosiljka(p);
            int ukupanRacun = 0;
            if(p.getTezina() <= 5){
                ukupanRacun = aktuelaniCenovnik.getCenaDo5kg() + p.getCenaOtkupa();
            }
             else if(p.getTezina() <= 10){
            ukupanRacun = aktuelaniCenovnik.getCenaOd5do10kg() + p.getCenaOtkupa();
             }
             else if(p.getTezina() > 10){
            ukupanRacun = aktuelaniCenovnik.getCenaPreko10kg() + p.getCenaOtkupa();
            }

            r.setUkupanRacun(ukupanRacun);
            racunRepository.saveAndFlush(r);
 //           Map.Entry<Posiljka, Integer> entry = new AbstractMap.SimpleEntry<Posiljka, Integer>(p, r.getUkupanRacun());
  //          return entry;
        return r;


    }

    @Override
    public List<Posiljka> getListaPisiljki(int idOsoba) {

        Optional<Osoba> getOsoba = osobaRepository.findById(idOsoba);
        if(getOsoba.isPresent()) {
            Osoba o = getOsoba.get();
            return posiljkaRepository.findAllByOsoba(o);
        }
        else{
            return null;
        }

    }

    @Override
    public List<Posiljka> getSvePosiljke() {
        return posiljkaRepository.findAllByStatusPosiljke(DOSTAVA);
    }

    @Override
    public boolean promeniStatus(int idPosiljka) {
        Optional<Posiljka> getIdPosiljka = posiljkaRepository.findById(idPosiljka);
        if(getIdPosiljka.isPresent()){
            Posiljka p = getIdPosiljka.get();
            p.setStatusPosiljke(DOSTAVLJENO);
            posiljkaRepository.saveAndFlush(p);
            return true;
        }
        else {
            return false;
        }

    }

//    @Override
//    public Posiljka getSifraPosiljke(int idOsoba) {
//
//        Optional<Osoba> optionalOsoba = osobaRepository.findById(idOsoba);
//        if(optionalOsoba.isPresent()){
//            Osoba o = optionalOsoba.get();
//            return posiljkaRepository.findByOsobaId(o);
//        }
//
//        return null;
//    }
}
