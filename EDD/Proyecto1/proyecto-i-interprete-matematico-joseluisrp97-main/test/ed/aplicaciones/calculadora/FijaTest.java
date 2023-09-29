/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.aplicaciones.calculadora;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;

/**
 * Pruebas unitarias para la evaluación de operaciones en notaciones prefija y
 * postfija.
 * 
 * @author blackzafiro
 */
public class FijaTest {
	@Test(expected = ParseException.class)
	public void evalúaPrefijaSimpleErrorTest() throws ParseException {
		String[] tokens = { "+", "43", "9.8", "3" };
		System.out.println(Arrays.toString(tokens) + " -> Error");
		double respuestaObtenida = Fija.evalúaPrefija(tokens);
	}

	@Test
	public void evalúaPrefijaSimpleTest() throws ParseException {
		String[] tokens = { "+", "43", "9.8" };
		double respuestaEsperada = 52.8;
		double respuestaObtenida = Fija.evalúaPrefija(tokens);
		System.out.println(Arrays.toString(tokens) + " = " + respuestaObtenida);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

	@Test(expected = ParseException.class)
	public void evalúaPostfijaSimpleErrorTest() throws ParseException {
		String[] tokens = { "+", "43", "9.8" };
		System.out.println(Arrays.toString(tokens) + " -> Error");
		double respuestaObtenida = Fija.evalúaPostfija(tokens);
	}

	@Test
	public void evalúaPostfijaSimpleTest() throws ParseException {
		String[] tokens = { "43", "9.8", "+" };
		double respuestaEsperada = 52.8;
		double respuestaObtenida = Fija.evalúaPostfija(tokens);
		System.out.println(Arrays.toString(tokens) + " = " + respuestaObtenida);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

	/* Tests extras implementados: */
	@Test
	public void evalúaPrefijaConExpresionCombinadaTest() throws ParseException {
		String[] tokens = { "-", "+", "4", "*", "2", "5", "3" };
		System.out.println(Arrays.toString(tokens) + " -> 11");
		double respuestaObtenida = Fija.evalúaPrefija(tokens);
		assertEquals(11, respuestaObtenida, 0);
	}

	@Test
	public void evalúaPostfijaConExpresionCombinadaTest() throws ParseException {
		String[] tokens = { "4", "2", "*", "5", "-" };
		System.out.println(Arrays.toString(tokens) + " -> 3");
		double respuestaObtenida = Fija.evalúaPostfija(tokens);
		assertEquals(3, respuestaObtenida, 0);
	}

	@Test(expected = ParseException.class)
	public void evaluaPostfijaConExpresionInvalidaTest() throws ParseException {
		String[] tokens = { "4", "+", "2", "+", "*" };
		Fija.evalúaPostfija(tokens);
	}

	@Test(expected = ArithmeticException.class)
	public void evaluaPrefijaConDivisionEntreCeroTest() throws ParseException {
		String[] tokens = { "/", "4", "0" };
		Fija.evalúaPrefija(tokens);
	}

}
