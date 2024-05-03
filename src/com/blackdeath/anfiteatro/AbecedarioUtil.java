package com.blackdeath.anfiteatro;

/**
 * Clase de utilería que permite operaciones relacionadas con el abecedario
 */
public class AbecedarioUtil {

	public static final String ABECEDARIO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

	/**
	 * Obtiene una letra del abecedario por su posición en el mismo. La primera
	 * posición es 1 y la última 27
	 * 
	 * @param posicion
	 * @return
	 */
	public static char obtenerLetraPorPosicion(int posicion) {
		if (posicion <= 0 || posicion > ABECEDARIO.length()) {
			throw new IllegalArgumentException("Posición de abecedario inválida");
		}

		return ABECEDARIO.charAt(posicion - 1);
	}
}
