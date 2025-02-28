package com.ucav.gestionProtocoloService.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Long getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(Long tipo_id) {
		this.tipo_id = tipo_id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Long getFormato_id() {
		return formato_id;
	}

	public void setFormato_id(Long formato_id) {
		this.formato_id = formato_id;
	}

	public Long getLocalizacion_id() {
		return localizacion_id;
	}

	public void setLocalizacion_id(Long localizacion_id) {
		this.localizacion_id = localizacion_id;
	}

	public Long getSoporte_id() {
		return soporte_id;
	}

	public void setSoporte_id(Long soporte_id) {
		this.soporte_id = soporte_id;
	}

	public Long getCertificado_id() {
		return certificado_id;
	}

	public void setCertificado_id(Long certificado_id) {
		this.certificado_id = certificado_id;
	}

	public Long getDifusion_id() {
		return difusion_id;
	}

	public void setDifusion_id(Long difusion_id) {
		this.difusion_id = difusion_id;
	}

	public Long getPublico_id() {
		return publico_id;
	}

	public void setPublico_id(Long publico_id) {
		this.publico_id = publico_id;
	}
	
	
}
