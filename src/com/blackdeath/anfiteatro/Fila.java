package com.blackdeath.anfiteatro;

import java.util.Map;
import java.util.TreeMap;

/**
 * Representa una fila de {@link Asiento}
 */
public class Fila {

	/**
	 * Letra con la que se identifica esta fila
	 */
	private char letra;

	/**
	 * {@link Asiento}s de esta fila
	 */
	private Asiento[] asientos;

	/**
	 * Mapa que permite obtener un {@link Asiento} por su identificador
	 */
	private Map<String, Asiento> mapaAsientos;

	/**
	 * Constructor que permite asignar la letra y {@link Asiento}s de esta fila
	 * 
	 * @param letra
	 * @param asientos
	 */
	public Fila(char letra, Asiento[] asientos) {
		this.letra = letra;
		this.asientos = asientos;

		mapaAsientos = new TreeMap<>();
		for (Asiento asiento : asientos) {
			mapaAsientos.put(asiento.getIdentificador(), asiento);
		}
	}

	/**
	 * Devuelve la letra de esta fila
	 * 
	 * @return
	 */
	public char getLetra() {
		return letra;
	}

	/**
	 * Devuelve los asientos de esta fila
	 * 
	 * @return
	 */
	public Asiento[] getAsientos() {
		return asientos;
	}

	/**
	 * Devuelve la cantidad de asientos de esta fila
	 * 
	 * @return
	 */
	public int getCantidadAsientos() {
		return asientos.length;
	}

	/**
	 * Obtiene un {@link Asiento} por su identificador
	 * 
	 * @param identificador
	 * @return
	 */
	public Asiento getAsientoPorIdentificador(String identificador) {
		return mapaAsientos.get(identificador);
	}
}
