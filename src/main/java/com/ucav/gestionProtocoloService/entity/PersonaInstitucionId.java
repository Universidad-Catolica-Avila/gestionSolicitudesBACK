package com.ucav.gestionProtocoloService.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PersonaInstitucionId implements Serializable {

	@Column(name = "IDpersona")
	private Integer idPersona;

	@Column(name = "IDInstitucion")
	private Integer idInstitucion;

	public PersonaInstitucionId() {
	}

	public PersonaInstitucionId(Integer idPersona, Integer idInstitucion) {
		this.idPersona = idPersona;
		this.idInstitucion = idInstitucion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PersonaInstitucionId that = (PersonaInstitucionId) o;
		return Objects.equals(idPersona, that.idPersona) && Objects.equals(idInstitucion, that.idInstitucion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona, idInstitucion);
	}

}