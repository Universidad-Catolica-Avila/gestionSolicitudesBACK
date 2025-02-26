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
public class PersonaCategoriaId implements Serializable {

	@Column(name = "IDpersona")
	private Integer idPersona;

	@Column(name = "IDCategoria")
	private Integer idCategoria;

	public PersonaCategoriaId() {
	}

	public PersonaCategoriaId(Integer idPersona, Integer idCategoria) {
		this.idPersona = idPersona;
		this.idCategoria = idCategoria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PersonaCategoriaId that = (PersonaCategoriaId) o;
		return Objects.equals(idPersona, that.idPersona) && Objects.equals(idCategoria, that.idCategoria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona, idCategoria);
	}

}