package com.ucav.gestionSolicitudesBACK.entity;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RolName name;
    
    @Column(length = 200)
    private String descripcion;

    public Rol() {

    }

    public Rol(RolName name) {
        this.name = name;
    }



}
