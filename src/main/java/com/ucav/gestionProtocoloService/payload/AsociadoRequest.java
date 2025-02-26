package com.ucav.gestionProtocoloService.payload;

import java.sql.Timestamp;

public class AsociadoRequest {
	
	private Long id;
	private String nombreFiscal;
    private Long codigoTipoCliente;
	private String cif;
	private String pais;
    private Long bic;
    private String codigoBanco;
    private Long codigoTipoSociedad;
    
    
    private String direccion;
    private String localidad;
    private String provincia;
    private Long codigoPostal;
    private String codigoSucursal;
    private String cuenta;
    private Boolean descatalogado;
    private String digitoControl;
    private String email;
    private Timestamp fechaAlta;
    private String iban;
    private Long naturaleza;    
    private Long numeroCliente;
    private String numeroColegiadoDgs;
    private String observaciones;
    private Boolean registradoWeb;
    private String telefono2;
    private String telefono;
    
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreFiscal() {
		return nombreFiscal;
	}
	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}
	public Long getCodigoTipoCliente() {
		return codigoTipoCliente;
	}
	public void setCodigoTipoCliente(Long tipo) {
		this.codigoTipoCliente = tipo;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Long getBic() {
		return bic;
	}
	public void setBic(Long bic) {
		this.bic = bic;
	}
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public Long getCodigoTipoSociedad() {
		return codigoTipoSociedad;
	}
	public void setCodigoTipoSociedad(Long codigoTipoSociedad) {
		this.codigoTipoSociedad = codigoTipoSociedad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Long getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public Boolean getDescatalogado() {
		return descatalogado;
	}
	public void setDescatalogado(Boolean descatalogado) {
		this.descatalogado = descatalogado;
	}
	public String getDigitoControl() {
		return digitoControl;
	}
	public void setDigitoControl(String digitoControl) {
		this.digitoControl = digitoControl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Long getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(Long numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getNumeroColegiadoDgs() {
		return numeroColegiadoDgs;
	}
	public void setNumeroColegiadoDgs(String numeroColegiadoDgs) {
		this.numeroColegiadoDgs = numeroColegiadoDgs;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Boolean getRegistradoWeb() {
		return registradoWeb;
	}
	public void setRegistradoWeb(Boolean registradoWeb) {
		this.registradoWeb = registradoWeb;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getNaturaleza() {
		return naturaleza;
	}
	public void setNaturaleza(Long naturaleza) {
		this.naturaleza = naturaleza;
	}


}
