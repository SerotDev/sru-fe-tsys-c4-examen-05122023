package com.sergi.examen.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios") // en caso que la tabala sea diferente
public class Usuario {
	// Atributos de entidad usuario
	@Id
	private int id;
	
	@Column(name = "nom_apels")
	private String nomApels;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "usuario_steam")
	private String usuarioSteam;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Party> party;

	// Constructores
	public Usuario() {
	}


	/**
	 * @param id
	 * @param nomApels
	 * @param username
	 * @param contrasena
	 * @param email
	 * @param usuarioSteam
	 * @param party
	 */
	public Usuario(int id, String nomApels, String username, String contrasena, String email, String usuarioSteam, List<Party> party) {
		this.id = id;
		this.nomApels = nomApels;
		this.username = username;
		this.contrasena = contrasena;
		this.email = email;
		this.usuarioSteam = usuarioSteam;
		this.party = party;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomApels() {
		return nomApels;
	}


	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsuarioSteam() {
		return usuarioSteam;
	}


	public void setUsuarioSteam(String usuarioSteam) {
		this.usuarioSteam = usuarioSteam;
	}

	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party") // Mapea la entidad
	public List<Party> getParty() {
		return party;
	}


	public void setParty(List<Party> party) {
		this.party = party;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomApels=" + nomApels + ", username=" + username + ", contrasena=" + contrasena
				+ ", email=" + email + ", usuarioSteam=" + usuarioSteam + "]";
	}

}
