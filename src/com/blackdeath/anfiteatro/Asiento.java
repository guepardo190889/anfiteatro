package com.blackdeath.anfiteatro;

/**
 * Clase que representa un asiento de un anfiteatro
 */
public class Asiento {

	private String identificador;

	/**
	 * Disponibilidad de este asiento
	 */
	private DISPONIBILIDAD disponibilidad;

	/**
	 * Constructor que permite asignar el identificador de un asiento y su
	 * disponibilidad
	 * 
	 * @param letraFila
	 * @param numeroAsiento
	 * @param disponibilidad
	 */
	public Asiento(String letraFila, int numeroAsiento, DISPONIBILIDAD disponibilidad) {
		identificador = letraFila + numeroAsiento;
		this.disponibilidad = disponibilidad;
	}

	/**
	 * Devuelve la {@link DISPONIBILIDAD} de este asiento
	 * 
	 * @return
	 */
	public DISPONIBILIDAD getDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * Devuelve {@code true} si el asiento está disponible y {@code false} si no lo
	 * está
	 * 
	 * @return
	 */
	public boolean isDisponible() {
		return DISPONIBILIDAD.LIBRE == disponibilidad;
	}

	/**
	 * Reserva este asiento
	 */
	public void reservar() {
		this.disponibilidad = DISPONIBILIDAD.OCUPADO;
	}

	/**
	 * Devuelve el identificador de este asiento
	 * 
	 * @return
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Enumerador que representa la disponibilidad de un asiento
	 */
	public enum DISPONIBILIDAD {
		LIBRE('L'), OCUPADO('X');

		private char valor;

		/**
		 * Constructor privado
		 * 
		 * @param valor
		 */
		private DISPONIBILIDAD(char valor) {
			this.valor = valor;
		}

		/**
		 * Devuelve el valor de la disponiblidad
		 * 
		 * @return
		 */
		public char getValor() {
			return valor;
		}
	}
}
