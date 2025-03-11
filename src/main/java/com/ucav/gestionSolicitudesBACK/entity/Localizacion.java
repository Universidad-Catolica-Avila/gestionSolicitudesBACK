package com.ucav.gestionSolicitudesBACK.entity;


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
@Table(name = "localizaciones")
public class Localizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @Size(max=50)
    private String descripcion;

    public Localizacion() { 
    }

    public Localizacion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}

