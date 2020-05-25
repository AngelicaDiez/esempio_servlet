package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "dipendente")
@Table(name = "dipendente")
public class Dipendente {

	@Id
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "cod_fiscale")
	private String cod_fiscale;
	
	@Column(name = "telefono")
	private int telefono;
	
	public Dipendente() {
		
	}

	public Dipendente(int id, String nome, String cognome, String cod_fiscale, int telefono) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cod_fiscale = cod_fiscale;
		this.telefono = telefono;
	}
	
	public Dipendente(String nome, String cognome, String cod_fiscale, int telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.cod_fiscale = cod_fiscale;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCod_fiscale() {
		return cod_fiscale;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCod_fiscale(String cod_fiscale) {
		this.cod_fiscale = cod_fiscale;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
