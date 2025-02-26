package com.ucav.gestionProtocoloService.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Instituciones")
@Getter
@Setter
public class Institucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdInstitucion")
	private Integer idInstitucion;

	@Column(name = "Nombre", length = 100)
	private String nombre;

	@Column(name = "Tipo", length = 100)
	private String tipo;
	
	@Column(name = "Localidad", length = 100)
	private String localidad;
	
	@Column(name = "Email", length = 100)
	private String email;
	
	@Column(name = "Telefono", length = 100)
	private String telefono;
	
	@Column(name = "Web", length = 100)
	private String web;
	
	@OneToMany(mappedBy = "institucion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<PersonaInstitucion> personaInstitucion;

}