package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_osoba")
	private int idOsoba;

	private String adresa;

	private String email;

	private String ime;

	private String pass;

	private String prezime;

	private String tel;

	private String username;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="osoba")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Posiljka
	@OneToMany(mappedBy="osoba")
	private List<Posiljka> posiljkas;

	public Osoba() {
	}

	public int getIdOsoba() {
		return this.idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setOsoba(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setOsoba(null);

		return komentar;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Posiljka> getPosiljkas() {
		return this.posiljkas;
	}

	public void setPosiljkas(List<Posiljka> posiljkas) {
		this.posiljkas = posiljkas;
	}

	public Posiljka addPosiljka(Posiljka posiljka) {
		getPosiljkas().add(posiljka);
		posiljka.setOsoba(this);

		return posiljka;
	}

	public Posiljka removePosiljka(Posiljka posiljka) {
		getPosiljkas().remove(posiljka);
		posiljka.setOsoba(null);

		return posiljka;
	}

}