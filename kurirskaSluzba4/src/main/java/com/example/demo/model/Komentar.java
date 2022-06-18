package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_komentar")
	private int idKomentar;

	private String odgovor;

	private String pitanje;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	public Komentar() {
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
	}

	public String getOdgovor() {
		return this.odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public String getPitanje() {
		return this.pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}