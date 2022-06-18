package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the racun database table.
 * 
 */
@Entity
@NamedQuery(name="Racun.findAll", query="SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_racun")
	private int idRacun;

	@Column(name="ukupan_racun")
	private int ukupanRacun;

	//bi-directional many-to-one association to Posiljka
	@ManyToOne
	private Posiljka posiljka;

	//bi-directional many-to-one association to Cenovnik
	@ManyToOne
	private Cenovnik cenovnik;

	public Racun() {
	}

	public int getIdRacun() {
		return this.idRacun;
	}

	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}

	public int getUkupanRacun() {
		return this.ukupanRacun;
	}

	public void setUkupanRacun(int ukupanRacun) {
		this.ukupanRacun = ukupanRacun;
	}

	public Posiljka getPosiljka() {
		return this.posiljka;
	}

	public void setPosiljka(Posiljka posiljka) {
		this.posiljka = posiljka;
	}

	public Cenovnik getCenovnik() {
		return this.cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

}