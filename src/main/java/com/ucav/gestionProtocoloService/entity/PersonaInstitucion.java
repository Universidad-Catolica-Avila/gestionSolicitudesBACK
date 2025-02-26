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
@Table(name = "PersonaInstitucion")
@Getter
@Setter
public class PersonaInstitucion {

	@EmbeddedId
	private PersonaInstitucionId id;

	@ManyToOne
	@MapsId("idPersona")
	@JoinColumn(name = "IDpersona", nullable = false)
	@JsonBackReference("persona-institucion") 
	private Persona persona;

	@ManyToOne
	@MapsId("idInstitucion")
	@JoinColumn(name = "IDInstitucion", nullable = false)
	private Institucion institucion;

	public PersonaInstitucion() {
	}

	public PersonaInstitucion(Persona persona, Institucion institucion) {
		//this.id = new PersonaInstitucionId(persona.getIdPersona(), institucion.getIdInstitucion());
		this.persona = persona;
		this.institucion = institucion;
	}
}