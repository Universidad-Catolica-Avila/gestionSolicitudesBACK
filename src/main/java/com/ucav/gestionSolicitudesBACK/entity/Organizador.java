package com.ucav.gestionSolicitudesBACK.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "organizadores")
public class Organizador {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	@Size(max = 50)
    private String nombre;
	
	@NotBlank
	@Size(max = 50)
    private String apellido;
	
	@NotBlank
	@Size(max = 100)
	@Email
    private String email;
	
	@NotBlank
	@Size(max = 50)
    private String telefono;
	
	
	public Organizador() {
		
	}

	public Organizador(			
			String nombre,
			String apellido,
			String email,
			String telefono
		) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	
}
