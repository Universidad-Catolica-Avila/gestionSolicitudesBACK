package com.ucav.gestionProtocoloService.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PersonaCategoria")
@Getter
@Setter
public class PersonaCategoria {

	@EmbeddedId
	private PersonaCategoriaId id;

	@ManyToOne
	@MapsId("idPersona")
	@JoinColumn(name = "IDpersona", nullable = false)
	@JsonBackReference("persona-categoria") 
	private Persona persona;

	@ManyToOne
	@MapsId("idCategoria")
	@JoinColumn(name = "IDCategoria", nullable = false)
	private Categoria categoria;

	public PersonaCategoria() {
	}

	public PersonaCategoria(Persona persona, Categoria categoria) {
		//this.id = new PersonaCategoriaId(persona.getIdPersona(), categoria.getIdCategoria());
		this.persona = persona;
		this.categoria = categoria;
	}

}