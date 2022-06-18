package com.example.demo.dto;

import java.util.Date;

public class PosiljkaDTO {

    private String adresaDostave;
    private int cenaOtkupa;
    private String opis;
    private String sifraPosiljke;
    private String statusPosiljke;
    private int tezina;
    private String vremeDostave;
    private String vremeSlanja;

    public String getAdresaDostave() {
        return adresaDostave;
    }

    public void setAdresaDostave(String adresaDostave) {
        this.adresaDostave = adresaDostave;
    }

    public int getCenaOtkupa() {
        return cenaOtkupa;
    }

    public void setCenaOtkupa(int cenaOtkupa) {
        this.cenaOtkupa = cenaOtkupa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSifraPosiljke() {
        return sifraPosiljke;
    }

    public void setSifraPosiljke(String sifraPosiljke) {
        this.sifraPosiljke = sifraPosiljke;
    }

    public String getStatusPosiljke() {
        return statusPosiljke;
    }

    public void setStatusPosiljke(String statusPosiljke) {
        this.statusPosiljke = statusPosiljke;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public String getVremeDostave() {
        return vremeDostave;
    }

    public void setVremeDostave(String vremeDostave) {
        this.vremeDostave = vremeDostave;
    }

    public String getVremeSlanja() {
        return vremeSlanja;
    }

    public void setVremeSlanja(String vremeSlanja) {
        this.vremeSlanja = vremeSlanja;
    }
}
