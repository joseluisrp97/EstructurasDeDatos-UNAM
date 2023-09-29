/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.aplicaciones.calculadora;

import java.text.ParseException;
import java.util.Stack;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Clase para evalúar expresiones en notación infija.
 *
 * @author blackzafiro
 */
public class Infija {

	/**
	 * Devuelve la precedencia de cada operador. Entre mayor es la precedencia,
	 * más pronto deverá ejecutarse la operación.
	 *
	 * @operador Símbolo que representa a las operaciones: +,-,*,/ y '('.
	 * @throws UnsupportedOperationException para cualquier otro símbolo.
	 */
	private static int precedencia(char operador) throws ParseException {
		int pre = -1;
		switch (operador) {
			case '(':
				pre = 0;
				break;
			case '+':
			case '-':
				prec = 1;
				break;
			case '*':
			case '/':
			case '%':
				prec = 2;
				break;
			default:
				throw new ParseException("Operador no reconocido: " + operador, 0);
		}
		return prec;
	}

	/**
	 * Pasa las operaciones indicadas en notación infija a notación sufija o
	 * postfija.
	 *
	 * @param tokens Arreglo con símbolos de operaciones (incluyendo paréntesis)
	 *               y números (según la definición aceptada por
	 *               <code>Double.parseDouble(token)</code> en orden infijo.
	 * @return Arreglo con símbolos de operaciones (sin incluir paréntesis) y
	 *         números en orden postfijo.
	 * @throws ParseException si la expresión contiene símbolos inválidos
	 *                        o el número de operadores y operandos no coincide.
	 */
	public static String[] infijaASufija(String[] tokens) throws ParseException {
		// Creamos una cola para almacenar los símbolos en notación posfija y una pila
		// para manejar la precedencia de operadores.
		LinkedList<String> cola = new LinkedList<>();
		Stack<String> pila = new Stack<>();

		// Recorremos cada símbolo de la expresión infija.
		for (String simbolo : tokens) {
			// Ignoramos los espacios en blanco.
			if (!simbolo.equals("")) {
				try {
					// Si el símbolo es un número, lo agregamos directamente a la cola.
					double valor = Double.parseDouble(simbolo);
					cola.offer(Double.toString(valor)); // Convertir valor a String
				} catch (NumberFormatException e) {
					// Si el símbolo es un paréntesis izquierdo, lo agregamos a la pila.
					if (simbolo.equals("(")) {
						pila.push(simbolo);
						// Si el símbolo es un paréntesis derecho, desapilamos operadores hasta
						// encontrar el paréntesis izquierdo.
					} else if (simbolo.equals(")")) {
						String tope = pila.pop();
						while (!tope.equals("(")) {
							cola.offer(tope);
							tope = pila.pop();
						}
						// Si el símbolo es un operador, desapilamos operadores de mayor o igual
						// precedencia hasta encontrar uno de menor precedencia o una pila vacía, y
						// luego apilamos el operador actual.
					} else {
						int prec = precedencia(simbolo.charAt(0));
						while (!pila.isEmpty() && precedencia(pila.peek().charAt(0)) >= prec) {
							cola.offer(pila.pop());
						}
						pila.push(simbolo);
					}
				}
			}
		}

		// Desapilamos cualquier operador restante de la pila y lo agregamos a la cola.
		while (!pila.isEmpty()) {
			cola.offer(pila.pop());
		}

		// Convertimos la cola en un arreglo de cadenas y lo retornamos.
		String[] retVal = new String[cola.size()];
		return cola.toArray(retVal);
	}

	/**
	 * Recibe la secuencia de símbolos de una expresión matemática en notación
	 * infija y calcula el resultado de evaluarla.
	 *
	 * @param tokens Lista de símbolos: operadores, paréntesis y números.
	 * @return resultado de la operación.
	 * @throws ParseException si la expresión contiene símbolos inválidos
	 *                        o el número de operadores y operandos no coincide.
	 */
	public static double evalúaInfija(String[] tokens) throws ParseException {
		// Convierte la expresión infija a una expresión posfija usando el método
		// infijaASufija
		String[] suf = infijaASufija(tokens);
		// Imprime la expresión posfija resultante
		System.out.println("Sufija: " + Arrays.toString(suf));
		// Evalúa la expresión posfija usando el método evalúaPostfija de la clase Fija
		return Fija.evalúaPostfija(suf);
	}

	/**
	 * Interfaz de texto para la calculadora.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence;
		String method = "infija";
		AnalizadorMatemático analizador = new AnalizadorMatemático();
		String[] tokens;

		System.out.println("Calculadora en modo notación " + method);
		while (true) {
			sentence = scanner.nextLine();
			switch (sentence) {
				case "exit":
					return;
				case "infija":
				case "prefija":
				case "postfija":
					System.out.println("Cambiando a notación " + sentence);
					method = sentence;
					continue;
				default:
					break;
			}
			tokens = analizador.extraeTokens(sentence);
			System.out.println("Tokens: " + Arrays.toString(tokens));
			double resultado;
			try {
				switch (method) {
					case "infija":
						resultado = evalúaInfija(tokens);
						break;
					case "prefija":
						resultado = Fija.evalúaPrefija(tokens);
						break;
					case "postfija":
						resultado = Fija.evalúaPostfija(tokens);
						break;
					default:
						System.out.println("Método inválido <" + method
								+ "> seleccione alguno de:\n"
								+ "\tinfija\n"
								+ "\tprefija\n"
								+ "\tpostfija\n");
						continue;
				}
				System.out.println("= " + resultado);
			} catch (ParseException pe) {
				System.out.println("Expresión inválida");
			}
		}
	}
}
