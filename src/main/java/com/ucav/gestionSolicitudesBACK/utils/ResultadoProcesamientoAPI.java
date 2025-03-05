package com.ucav.gestionSolicitudesBACK.utils;

public class ResultadoProcesamientoAPI {
	private String idPeople;
	private String imageName;
	private String estado;
	private String mensaje;

	public ResultadoProcesamientoAPI(String idPeople, String imageName, String estado, String mensaje) {
		this.idPeople = idPeople;
		this.imageName = imageName;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	// Getters y setters
	public String getIdPeople() {
		return idPeople;
	}

	public void setIdPeople(String idPeople) {
		this.idPeople = idPeople;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "idPeople: " + idPeople + ", imageName: " + imageName + ", estado: " + estado + ", mensaje: "
				+ mensaje;
	}
}
