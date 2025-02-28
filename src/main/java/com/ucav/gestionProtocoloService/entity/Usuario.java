package com.ucav.gestionProtocoloService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ucav.gestionProtocoloService.entity.audit.UserDateAudit;


@Entity
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
    
    @Column(name = "tipo_id")
    private Long tipo_id;
     
    
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
        this.tipo_id = tipo_id; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Long getTipoId() {
        return tipo_id;
    }

    public void setTipoId(Long tipo_id) {
        this.tipo_id = tipo_id;
    }
}