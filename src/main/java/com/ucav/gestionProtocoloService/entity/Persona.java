package com.ucav.gestionProtocoloService.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Personas", uniqueConstraints = { @UniqueConstraint(columnNames = { "IDpersona" }) })
@Getter
@Setter
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDpersona")
	private Integer idPersona;

	@Column(name = "Nombre", length = 50, nullable = false)
	private String nombre;

	@Column(name = "Trato", length = 50)
	private String trato;

	@Column(name = "Cargo", length = 50)
	private String cargo;

	@Column(name = "Direccion1", length = 80)
	private String direccion1;

	@Column(name = "Direccion2", length = 100)
	private String direccion2;

	@Column(name = "Direccion3", length = 100)
	private String direccion3;

	@Column(name = "Direccion4", length = 100)
	private String direccion4;

	@Column(name = "Telefono1", length = 20)
	private String telefono1;


	@Column(name = "Telefono2", length = 20)
	private String telefono2;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "email2", length = 100)
	private String email2;

	@Column(name = "email3", length = 100)
	private String email3;

	@Column(name = "Universidad", length = 50)
	private String universidad;

	@Column(name = "createdAt")	
	private LocalDateTime createdAt;

	@Column(name = "updatedAt")	
	private LocalDateTime updatedAt;

	@Column(name = "createdBy", length = 255)
	private String createdBy;

	@Column(name = "updatedBy", length = 255)
	private String updatedBy;

	@Column(name = "Observaciones", length = 100)
	private String observaciones;

	@Column(name = "Confirmacion", length = 50)
	private String confirmacion;

	@Column(name = "NumConfirmacion", length = 50)
	private String numConfirmacion;

	@OneToMany(mappedBy = "persona")
	@JsonManagedReference("persona-categoria") 
	private Set<PersonaCategoria> personaCategorias;

	@OneToMany(mappedBy = "persona")
	@JsonManagedReference("persona-institucion")
	private Set<PersonaInstitucion> personalInstitucion;


}