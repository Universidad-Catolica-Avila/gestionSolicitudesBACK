package com.ucav.gestionSolicitudesBACK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ucav.gestionSolicitudesBACK.entity.audit.UserDateAudit;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class Usuario extends UserDateAudit {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    private String username;
    
    @NotBlank
    @JsonIgnore
    @Size(max = 100)
    private String password;
    
    @NotBlank
    @Size(max = 100)
    private String nombre;
    
    @NaturalId
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;
    
    @Size(max = 10)
    private String telefono;    

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
     
    
    public Usuario() {

    }

    public Usuario(
    		String username, 
    		String password, 
    		String nombre,  
    		String email, 
    		String telefono, 
    		Long tipo_id
	) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
       
    }

    
}