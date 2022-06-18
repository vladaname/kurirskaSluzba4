package com.example.demo.service.impl;

import com.example.demo.dto.OsobaDTO;
import com.example.demo.model.Osoba;
import com.example.demo.model.Uloga;
import com.example.demo.repository.OsobaRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.service.OsobaService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OsobaServiceImpl implements OsobaService {

    @Autowired
    OsobaRepository osobaRepository;
    @Autowired
    UlogaRepository ulogaRepository;
    @Override
    public boolean createOsoba(OsobaDTO osobaDTO) {

        try {
            Osoba o = new Osoba();
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            o.setIme(osobaDTO.getIme());
            o.setPrezime(osobaDTO.getPrezime());
            o.setAdresa(osobaDTO.getAdresa());
            o.setEmail(osobaDTO.getEmail());
            o.setTel(osobaDTO.getTel());
            o.setUsername(osobaDTO.getUsername());
            o.setPass(passwordEncryptor.encryptPassword(osobaDTO.getPass()));

            Optional<Uloga> setUloga = ulogaRepository.findById(1);
            if (setUloga.isPresent()) {
                Uloga u = setUloga.get();
                o.setUloga(u);
            } else {
                return false;
            }
            osobaRepository.saveAndFlush(o);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Osoba login(OsobaDTO osobaDTO) {
        try {
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

            Osoba o = osobaRepository.findByUsername(osobaDTO.getUsername());
                String encryptedPass = o.getPass();
            if (osobaDTO.getPass().equals(o.getPass()) || passwordEncryptor.checkPassword(osobaDTO.getPass(), encryptedPass)){
                    return o;
                }
                else{
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
