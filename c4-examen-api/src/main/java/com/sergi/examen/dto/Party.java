package com.sergi.examen.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Partys")//en caso que la tabala sea diferente
public class Party {
	//Atributos de entidad party
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "id_videojuego")
    Videojuego videojuego;
 
	
	//Constructores
	public Party() {
	}


	/**
	 * @param id
	 * @param nombre
	 * @param usuario
	 * @param videojuego
	 */
	public Party(int id, String nombre, Usuario usuario, Videojuego videojuego) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.videojuego = videojuego;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Videojuego getVideojuego() {
		return videojuego;
	}


	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}


	@Override
	public String toString() {
		return "Party [id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", videojuego=" + videojuego + "]";
	}
	
}
