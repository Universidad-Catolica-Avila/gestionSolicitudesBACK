package com.ucav.gestionSolicitudesBACK.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "eventos")
public class Evento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    @Size(max = 50)
    private String nombre;
	
	@NotBlank
    @Size(max = 100)
    private String responsable;
	
	@NotBlank
	@Column(name = "tipo_id")
    private Long tipo_id;
	
	@NotBlank
	private Date fecha_inicio;
	
	@NotBlank
	private Date fecha_fin;
	
	@NotBlank
	private String programa;
	
	@NotBlank
	@Size(max = 255)
	private String institucion;
	
	@NotBlank
	@Size(max = 255)	
	private String colaboradores;
	
	@NotBlank
	@Column(name = "formato_id")
    private Long formato_id;
	
	@NotBlank
	@Column(name = "localizacion_id")
    private Long localizacion_id;
	
	@NotBlank
	@Column(name = "soporte_id")
    private Long soporte_id;
	
	@NotBlank
	@Column(name = "certificado_id")
    private Long certificado_id;
	
	@NotBlank
	@Column(name = "difusion_id")
    private Long difusion_id;
	
	@NotBlank
	@Column(name = "publico_id")
    private Long publico_id;
	
	
	public Evento() {
		
	}

	public Evento(
			Long id, 
			String nombre, 
			String responsable,
			Long tipo_id, 
			Date fecha_inicio, 
			Date fecha_fin, 
			String programa,
			String institucion, 
			String colaboradores,
			Long formato_id,
			Long localizacion_id,
			Long soporte_id,
			Long certificado_id,
			Long difusion_id,
			Long publico_id
		) {
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		this.tipo_id = tipo_id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.programa = programa;
		this.institucion = institucion;
		this.colaboradores = colaboradores;
		this.formato_id = formato_id;
		this.localizacion_id = localizacion_id;
		this.soporte_id = soporte_id;
		this.certificado_id = certificado_id;
		this.difusion_id = difusion_id;
		this.publico_id = publico_id;
	}
	

	
	
}
