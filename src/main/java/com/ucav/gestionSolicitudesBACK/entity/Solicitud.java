package com.ucav.gestionSolicitudesBACK.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "solicitudes")
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoEvento tipo;

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

    @ManyToOne
    @JoinColumn(name = "formato_id", nullable = false)
    private FormatoEvento formato;

    @ManyToOne
    @JoinColumn(name = "localizacion_id", nullable = false)
    private Localizacion localizacion;

    @ManyToOne
    @JoinColumn(name = "soporte_id", nullable = false)
    private Soporte soporte;

    @ManyToOne
    @JoinColumn(name = "certificado_id", nullable = false)
    private Certificado certificado;

    @ManyToOne
    @JoinColumn(name = "difusion_id", nullable = false)
    private Difusion difusion;

    @ManyToOne
    @JoinColumn(name = "publico_id", nullable = false)
    private Publico publico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    private EstadoEvento estado;

    @Column(name = "observaciones")
    private String observaciones;

    public Solicitud() {}
}

