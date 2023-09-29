/*
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.aplicaciones.calculadora;

import java.util.Stack;
import java.util.Scanner;
import java.text.ParseException;

/**
 * Clase para evalúar expresiones en notaciones prefija y postfija.
 *
 * @author blackzafiro
 */
public class Fija {

	/**
	 * Evalúa la operación indicada por <code>operador</code>. Por ejemplo: si
	 * operador es '*' devuelve operador1 * operador2.
	 *
	 * @param operador  character con el operador correspondiente a la operación
	 *                  que se desea realizar.
	 * @param operando1 primer operando.
	 * @param operando2 segundo operando.
	 * @return el resultado de aplicar la operación a los operandos.
	 */
	private static double evalúa(char operador, double operando1, double operando2) {
		double res = 0;
		switch (operador) {
			case '+':
				res = operando1 + operando2;
				break;
			case '-':
				res = operando1 - operando2;
				break;
			case '*':
				res = operando1 * operando2;
				break;
			case '/':
				res = operando1 / operando2;
				break;
			case '%':
				res = operando1 % operando2;
				break;
		}
		return res;
	}

	/**
	 * Verifica si un String es un double.
	 * 
	 * @param expr cadena que posiblemente represente un número.
	 * @return true si expr es un double, falso en otro caso.
	 */
	public static boolean esDouble(String expr) {
		int ndots = 0; // cuenta el número de puntos en la expresión.
		int inicio = 0;
		if (expr.charAt(0) == '-' && expr.length() > 1) {
			inicio = 1;
		}
		for (int i = inicio; i < expr.length(); i++) {
			char ca = expr.charAt(i); // caracter actual.
			if (Character.isDigit(ca) || ca == '.') {
				if (ca == '.') {
					ndots++;
				}
			} else {
				return false;
			}
		}

		if (ndots > 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Recibe la secuencia de símbolos de una expresión matemática en notación
	 * prefija y calcula el resultado de evaluarla.
	 *
	 * @param tokens Lista de símbolos: operadores y números.
	 * @return resultado de la operación.
	 * @throws ParseException si la expresión contiene símbolos inválidos
	 *                        o el número de operadores y operandos no coincide.
	 */
	public static double evalúaPrefija(String[] tokens) throws ParseException, ArithmeticException {
		Stack<Double> pila = new Stack<>();
		int contadorOperandos = 0;
		int contadorOperadores = 0;
		// Recorre los tokens en orden inverso
		for (int i = tokens.length - 1; i >= 0; i--) {
			String simbolo = tokens[i];
			if (esDouble(simbolo)) { // Si el símbolo es un número
				pila.push(Double.parseDouble(simbolo)); // Lo convierte a double y lo añade a la pila
				contadorOperandos++;
			} else { // Si el símbolo es un operador
				contadorOperadores++;
				if (contadorOperadores > contadorOperandos - 1) { // Comprueba si hay suficientes operandos en la pila
					throw new ParseException(
							"Error: la expresión contiene símbolos inválidos o el número de operadores y operandos no coincide",
							i);
				}
				double op1 = pila.pop(); // Obtiene el primer operando de la pila
				double op2 = pila.pop(); // Obtiene el segundo operando de la pila
				if (simbolo.equals("/") && op2 == 0) { // Comprueba si se intenta dividir por cero
					throw new ArithmeticException("Error: división entre cero");
				}
				pila.push(evalúa(simbolo.charAt(0), op1, op2)); // Realiza la operación y añade el resultado a la pila
			}
		}

		// Comprueba que solo haya un resultado en la pila
		if (contadorOperandos - contadorOperadores != 1) {
			throw new ParseException(
					"Error: la expresión contiene símbolos inválidos o el número de operadores y operandos no coincide",
					0);
		}
		return pila.pop(); // Devuelve el resultado final de la evaluación

	}

	/**
	 * Recibe la secuencia de símbolos de una expresión matemática en notación
	 * postfija y calcula el resultado de evaluarla.
	 *
	 * @param tokens Lista de símbolos: operadores y números.
	 * @return resultado de la operación.
	 * @throws ParseException si la expresión contiene símbolos inválidos
	 *                        o el número de operadores y operandos no coincide.
	 */
	public static double evalúaPostfija(String[] tokens) throws ParseException {
		Stack<Double> pila = new Stack<>();
		int contadorOperandos = 0; // contador de operandos
		int contadorOperadores = 0; // contador de operadores

		for (String simbolo : tokens) {
			if (esDouble(simbolo)) { // si es un número, lo apilamos en la pila
				pila.push(Double.parseDouble(simbolo));
				contadorOperandos++;
			} else { // si es un operador, desapilamos dos operandos y realizamos la operación
				contadorOperadores++;
				if (contadorOperadores >= contadorOperandos) {
					// si hay más operadores que operandos, la expresión es inválida
					throw new ParseException(
							"Error: la expresión contiene símbolos inválidos o el número de operadores y operandos no coincide",
							0);
				}
				double op2 = pila.pop();
				double op1 = pila.pop();
				pila.push(evalúa(simbolo.charAt(0), op1, op2)); // apilamos el resultado de la operación
			}
		}

		if (contadorOperandos - contadorOperadores != 1) {
			// si el número de operandos menos el número de operadores no es igual a 1, la
			// expresión es inválida
			throw new ParseException(
					"Error: la expresión contiene símbolos inválidos o el número de operadores y operandos no coincide",
					0);
		}

		return pila.pop(); // devolvemos el último valor de la pila, que es el resultado final
	}

	/**
	 * Interfaz de texto para la calculadora.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence;
		String method = "prefija";
		AnalizadorMatemático analizador = new AnalizadorMatemático();
		String[] tokens;

		System.out.println("Calculadora en modo notación " + method);
		while (true) {
			sentence = scanner.nextLine();
			switch (sentence) {
				case "exit":
					return;
				case "prefija":
				case "postfija":
					System.out.println("Cambiando a notación " + sentence);
					method = sentence;
					continue;
				default:
					break;
			}
			tokens = analizador.extraeTokens(sentence);
			try {
				if (method.equals("postfija")) {
					System.out.println("= " + evalúaPostfija(tokens));
				} else {
					System.out.println("= " + evalúaPrefija(tokens));
				}
			} catch (ParseException pe) {
				System.out.println("Expresión inválida");
			}
		}
	}
}
