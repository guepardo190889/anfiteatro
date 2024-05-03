package com.blackdeath.anfiteatro;

/**
 * Esta clase de utilería representa la pantalla que ve el usuario
 */
public class Pantalla {

	private static final int PRIMERA_FILA = 0;
	private static final char ESPACIO = ' ';
	private static final char SEPARADOR = '|';
	private static final char GUION_MEDIO = '-';
	private static final char GUION_BAJO = '_';
	private static final String TEXTO_PANTALLA = "P A N T A L L A";
	private static final int MINIMO_ASIENTO_DOS_DIGITOS = 10;
	private static final int CANTIDAD_GUION_MEDIO_POR_ASIENTO = 4;
	private static final int CANTIDAD_GUION_BAJO_POR_ASIENTO = 4;

	/**
	 * Imprime las filas
	 * 
	 * @param filas
	 */
	public static void iprimirFilas(Fila[] filas) {
		int cantidadAsientos = filas[PRIMERA_FILA].getCantidadAsientos();

		imprimirTitulos(cantidadAsientos);
		imprimirLineaPunteada(cantidadAsientos);

		for (Fila fila : filas) {
			imprimirFila(fila);
			imprimirLineaPunteada(cantidadAsientos);
		}

		imprimirLineaContinua(cantidadAsientos);
		imprimirTextoPantalla(cantidadAsientos);
	}

	/**
	 * Imprime los títulos de la pantalla
	 * 
	 * @param cantidadAsientos
	 */
	private static void imprimirTitulos(int cantidadAsientos) {
		StringBuilder titulos = new StringBuilder().append(ESPACIO).append(ESPACIO).append(ESPACIO);
		for (int asiento = 1; asiento <= cantidadAsientos; asiento++) {
			if (asiento < MINIMO_ASIENTO_DOS_DIGITOS) {
				titulos.append(asiento).append(ESPACIO).append(ESPACIO).append(ESPACIO);
			} else {
				titulos.append(asiento).append(ESPACIO).append(ESPACIO);
			}
		}

		System.out.println(titulos.toString());
	}

	/**
	 * Imprime una línea punteada
	 * 
	 * @param cantidadAsientos
	 */
	private static void imprimirLineaPunteada(int cantidadAsientos) {
		StringBuilder linea = new StringBuilder().append(ESPACIO).append(ESPACIO);
		linea.append(concatenerCaracterRepetido(CANTIDAD_GUION_MEDIO_POR_ASIENTO * cantidadAsientos, GUION_MEDIO));
		linea.append(GUION_MEDIO);

		System.out.println(linea.toString());
	}

	/**
	 * Imprime una línea contínua
	 * 
	 * @param cantidadAsientos
	 */
	private static void imprimirLineaContinua(int cantidadAsientos) {
		StringBuilder linea = new StringBuilder().append(ESPACIO).append(ESPACIO);
		linea.append(concatenerCaracterRepetido(CANTIDAD_GUION_BAJO_POR_ASIENTO * cantidadAsientos, GUION_BAJO));
		linea.append(GUION_BAJO);

		System.out.println(linea.toString());
	}

	/**
	 * Construye una cadena de texto repetiendo el {@code caracter} proporcionado
	 * por {@code cantidadRepeticiones}
	 * 
	 * @param cantidadRepeticiones
	 * @param caracter
	 * @return
	 */
	private static StringBuilder concatenerCaracterRepetido(int cantidadRepeticiones, char caracter) {
		StringBuilder linea = new StringBuilder();

		for (int i = 1; i <= cantidadRepeticiones; i++) {
			linea.append(caracter);
		}

		return linea;
	}

	/**
	 * Imprime una {@link Fila}
	 * 
	 * @param fila
	 */
	private static void imprimirFila(Fila fila) {
		StringBuilder linea = new StringBuilder().append(fila.getLetra()).append(ESPACIO);

		for (Asiento asiento : fila.getAsientos()) {
			linea.append(SEPARADOR).append(ESPACIO).append(asiento.getDisponibilidad().getValor()).append(ESPACIO);
		}

		linea.append(SEPARADOR);

		System.out.println(linea.toString());
	}

	/**
	 * Imprime el texto 'PANTALLA' centrado según la {@code cantidadAsientos}
	 * 
	 * @param cantidadAsientos
	 */
	private static void imprimirTextoPantalla(int cantidadAsientos) {
		int tamaioLinea = (cantidadAsientos * CANTIDAD_GUION_MEDIO_POR_ASIENTO) + 3;
		int posicionMedio = tamaioLinea / 2;
		int tamanioTextoPantalla = TEXTO_PANTALLA.length();
		int cantidadCaracteresTextoPantallaIzquierda = tamanioTextoPantalla / 2;
		int posicionInicioTextoPantalla = posicionMedio - cantidadCaracteresTextoPantallaIzquierda;

		StringBuilder linea = new StringBuilder();

		for (int i = 0; i < posicionInicioTextoPantalla; i++) {
			linea.append(ESPACIO);
		}

		linea.append(TEXTO_PANTALLA);

		for (int i = linea.length(); i < tamaioLinea; i++) {
			linea.append(ESPACIO);
		}

		System.out.println(linea.toString());
	}

}
