package com.ucav.gestionSolicitudesBACK.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "evento")
    private List<Solicitud> solicitudes;
    
    public Evento() {}
}
