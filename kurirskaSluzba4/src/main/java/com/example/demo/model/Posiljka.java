package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the posiljka database table.
 * 
 */
@Entity
@NamedQuery(name="Posiljka.findAll", query="SELECT p FROM Posiljka p")
public class Posiljka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_posiljka")
	private int idPosiljka;

	@Column(name="adresa_dostave")
	private String adresaDostave;

	@Column(name="cena_otkupa")
	private int cenaOtkupa;

	private String opis;

	@Column(name="sifra_posiljke")
	private String sifraPosiljke;

	@Column(name="status_posiljke")
	private String statusPosiljke;

	private int tezina;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vreme_dostave")
	private Date vremeDostave;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vreme_slanja")
	private Date vremeSlanja;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	//bi-directional many-to-one association to Racun
	@OneToMany(mappedBy="posiljka")
	private List<Racun> racuns;

	public Posiljka() {
	}

	public int getIdPosiljka() {
		return this.idPosiljka;
	}

	public void setIdPosiljka(int idPosiljka) {
		this.idPosiljka = idPosiljka;
	}

	public String getAdresaDostave() {
		return this.adresaDostave;
	}

	public void setAdresaDostave(String adresaDostave) {
		this.adresaDostave = adresaDostave;
	}

	public int getCenaOtkupa() {
		return this.cenaOtkupa;
	}

	public void setCenaOtkupa(int cenaOtkupa) {
		this.cenaOtkupa = cenaOtkupa;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSifraPosiljke() {
		return this.sifraPosiljke;
	}

	public void setSifraPosiljke(String sifraPosiljke) {
		this.sifraPosiljke = sifraPosiljke;
	}

	public String getStatusPosiljke() {
		return this.statusPosiljke;
	}

	public void setStatusPosiljke(String statusPosiljke) {
		this.statusPosiljke = statusPosiljke;
	}

	public int getTezina() {
		return this.tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public Date getVremeDostave() {
		return this.vremeDostave;
	}

	public void setVremeDostave(Date vremeDostave) {
		this.vremeDostave = vremeDostave;
	}

	public Date getVremeSlanja() {
		return this.vremeSlanja;
	}

	public void setVremeSlanja(Date vremeSlanja) {
		this.vremeSlanja = vremeSlanja;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public List<Racun> getRacuns() {
		return this.racuns;
	}

	public void setRacuns(List<Racun> racuns) {
		this.racuns = racuns;
	}

	public Racun addRacun(Racun racun) {
		getRacuns().add(racun);
		racun.setPosiljka(this);

		return racun;
	}

	public Racun removeRacun(Racun racun) {
		getRacuns().remove(racun);
		racun.setPosiljka(null);

		return racun;
	}

}