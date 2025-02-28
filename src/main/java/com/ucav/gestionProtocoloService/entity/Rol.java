package com.ucav.gestionProtocoloService.entity;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolName getName() {
        return name;
    }

    public void setName(RolName name) {
        this.name = name;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
