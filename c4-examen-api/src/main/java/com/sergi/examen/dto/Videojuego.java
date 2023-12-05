package com.sergi.examen.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Videojuegos")//en caso que la tabala sea diferente
public class Videojuego {
	//Atributos de entidad videojuego
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Party> party;
	
	//Constructores
	public Videojuego() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param party
	 */
	public Videojuego(int id, String nombre, List<Party> party) {
		this.id = id;
		this.nombre = nombre;
		this.party = party;
	}

	//Getters y Setters
	/**
	 * @return returns the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id sets the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return returns the name
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre sets the name
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the party
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party") // Mapea la entidad
	public List<Party> getParty() {
		return party;
	}
	/**
	 * @param party set the party
	 */
	public void setParty(List<Party> party) {
		this.party = party;
	}
	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + "]";
	}
	
}