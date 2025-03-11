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
@Table(name = "difusiones")
public class Difusion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @Size(max=255)
    private String descripcion;

    public Difusion() { 
    }

    public Difusion(String descripcion) {
        this.descripcion = descripcion;
    }

  
}

