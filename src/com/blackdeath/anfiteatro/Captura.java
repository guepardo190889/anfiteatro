package com.blackdeath.anfiteatro;

/**
 * Representa un dato capturado por el usuario
 */
public class Captura {

	private String captura;
	private TipoCaptura tipoCaptura;

	public Captura(String captura, TipoCaptura tipoCaptura) {
		this.captura = captura;
		this.tipoCaptura = tipoCaptura;
	}

	public String getCaptura() {
		return captura;
	}

	public TipoCaptura getTipoCaptura() {
		return tipoCaptura;
	}

	public enum TipoCaptura {
		RESERVACION, FINALIZACION
	}

}
