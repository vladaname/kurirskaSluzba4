package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cenovnik database table.
 * 
 */
@Entity
@NamedQuery(name="Cenovnik.findAll", query="SELECT c FROM Cenovnik c")
public class Cenovnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cenovnik")
	private int idCenovnik;

	@Column(name="cena_do5kg")
	private int cenaDo5kg;

	@Column(name="cena_od5do10kg")
	private int cenaOd5do10kg;

	@Column(name="cena_preko10kg")
	private int cenaPreko10kg;

	//bi-directional many-to-one association to Racun
	@OneToMany(mappedBy="cenovnik")
	private List<Racun> racuns;

	public Cenovnik() {
	}

	public int getIdCenovnik() {
		return this.idCenovnik;
	}

	public void setIdCenovnik(int idCenovnik) {
		this.idCenovnik = idCenovnik;
	}

	public int getCenaDo5kg() {
		return this.cenaDo5kg;
	}

	public void setCenaDo5kg(int cenaDo5kg) {
		this.cenaDo5kg = cenaDo5kg;
	}

	public int getCenaOd5do10kg() {
		return this.cenaOd5do10kg;
	}

	public void setCenaOd5do10kg(int cenaOd5do10kg) {
		this.cenaOd5do10kg = cenaOd5do10kg;
	}

	public int getCenaPreko10kg() {
		return this.cenaPreko10kg;
	}

	public void setCenaPreko10kg(int cenaPreko10kg) {
		this.cenaPreko10kg = cenaPreko10kg;
	}

	public List<Racun> getRacuns() {
		return this.racuns;
	}

	public void setRacuns(List<Racun> racuns) {
		this.racuns = racuns;
	}

	public Racun addRacun(Racun racun) {
		getRacuns().add(racun);
		racun.setCenovnik(this);

		return racun;
	}

	public Racun removeRacun(Racun racun) {
		getRacuns().remove(racun);
		racun.setCenovnik(null);

		return racun;
	}

}