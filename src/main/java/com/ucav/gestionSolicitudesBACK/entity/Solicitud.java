package com.ucav.gestionSolicitudesBACK.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "solicitudes")
public class Solicitud {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	@Column(name = "organizador_id")
    private Long organizador_id;
	
	@NotBlank
	@Column(name = "evento_id")
    private Long evento_id;
	
	@NotBlank
	@Column(name = "estado_id")
    private Long estado_id;
	
	@Column(name = "observaciones_id")
    private String observaciones_id;
	
	
	public Solicitud() {
		
	}

	public Solicitud(			
			Long id, 
			Long organizador_id, 
			Long evento_id,
			Long estado_id,
			String observaciones_id
		) {
		
		this.id = id;
		this.organizador_id = organizador_id;
		this.evento_id = evento_id;
		this.estado_id = estado_id;
		this.observaciones_id = observaciones_id;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizador_id() {
		return organizador_id;
	}

	public void setOrganizador_id(Long organizador_id) {
		this.organizador_id = organizador_id;
	}

	public Long getEvento_id() {
		return evento_id;
	}

	public void setEvento_id(Long evento_id) {
		this.evento_id = evento_id;
	}

	public Long getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Long estado_id) {
		this.estado_id = estado_id;
	}

	public String getObservaciones_id() {
		return observaciones_id;
	}

	public void setObservaciones_id(String observaciones_id) {
		this.observaciones_id = observaciones_id;
	}
}
