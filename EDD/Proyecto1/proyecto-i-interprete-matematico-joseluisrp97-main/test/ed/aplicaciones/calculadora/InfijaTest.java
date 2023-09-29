/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.aplicaciones.calculadora;

import java.text.ParseException;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.System.out;

/**
 * Pruebas unitarias para la evalución de operaciones aritméticas con notación
 * infija.
 *
 * @author blackzafiro
 */
public class InfijaTest {

	@Test
	public void infijaASufijaBasicTest() throws ParseException {
		out.println("\n>> infijaASufijaBasicTest <<");
		String[] tokens = { "5", "*", "-2" };
		String[] respuestaEsperada = { "5.0", "-2.0", "*" };
		String[] respuestaObtenida = Infija.infijaASufija(tokens);
		out.println(Arrays.toString(tokens) + " -> "
				+ Arrays.toString(respuestaObtenida));
		assertArrayEquals(respuestaEsperada, respuestaObtenida);
	}

	@Test
	public void evalúaInfijaBasicTest() throws ParseException {
		out.println("\n>> evalúaInfijaBasicTest <<");
		String[] tokens = { "5", "*", "-2" };
		double respuestaEsperada = -10;
		double respuestaObtenida = Infija.evalúaInfija(tokens);
		System.out.println(Arrays.toString(tokens) + " = " + respuestaObtenida);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

	@Test
	public void infijaASufijaSimpleTest() throws ParseException {
		out.println("\n>> infijaASufijaSimpleTest <<");
		String[] tokens = { "5", "*", "(", "3", "+", "-2", ")" };
		String[] respuestaEsperada = { "5.0", "3.0", "-2.0", "+", "*" };
		String[] respuestaObtenida = Infija.infijaASufija(tokens);
		System.out.println(Arrays.toString(tokens) + " -> "
				+ Arrays.toString(respuestaObtenida));
		assertArrayEquals(respuestaEsperada, respuestaObtenida);
	}

	@Test
	public void evalúaInfijaSimpleTest() throws ParseException {
		out.println("\n>> evalúaInfijaSimpleTest <<");
		String[] tokens = { "5", "*", "(", "3", "+", "-2", ")" };
		double respuestaEsperada = 5.0;
		double respuestaObtenida = Infija.evalúaInfija(tokens);
		System.out.println(Arrays.toString(tokens) + " = " + respuestaObtenida);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

	@Test
	public void infijaASufijaCompuestaTest() throws ParseException {
		out.println("\n>> infijaASufijaCompuestaTest <<");
		String[] tokens = { "5", "*", "(", "(", "-3", "+", "-2", ")", "*", "-1", ")" };
		String[] respuestaEsperada = { "5.0", "-3.0", "-2.0", "+", "-1.0", "*", "*" };
		String[] respuestaObtenida = Infija.infijaASufija(tokens);
		System.out.println(Arrays.toString(tokens) + " -> "
				+ Arrays.toString(respuestaObtenida));
		assertArrayEquals(respuestaEsperada, respuestaObtenida);
	}

	@Test
	public void evalúaInfijaCompuestaTest() throws ParseException {
		out.println("\n>> evalúaInfijaCompuestaTest <<");
		String[] tokens = { "5", "*", "(", "(", "-3", "+", "-2", ")", "*", "-1", ")" };
		double respuestaEsperada = 25;
		double respuestaObtenida = Infija.evalúaInfija(tokens);
		System.out.println(Arrays.toString(tokens) + " = " + respuestaObtenida);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

	/* Test extras implementados */
	@Test
	public void infijaASufijaConParentesisTest() throws ParseException {
		String[] tokens = { "(", "2", "+", "3", ")", "*", "4" };
		String[] respuestaEsperada = { "2.0", "3.0", "+", "4.0", "*" };
		String[] respuestaObtenida = Infija.infijaASufija(tokens);
		assertArrayEquals(respuestaEsperada, respuestaObtenida);
	}

	@Test
	public void infijaASufijaConMultiplesParentesisTest() throws ParseException {
		String[] tokens = { "(", "2", "+", "(", "3", "-", "1", ")", ")", "/", "4" };
		String[] respuestaEsperada = { "2.0", "3.0", "1.0", "-", "+", "4.0", "/" };
		String[] respuestaObtenida = Infija.infijaASufija(tokens);
		assertArrayEquals(respuestaEsperada, respuestaObtenida);
	}

	@Test
	public void evaluaInfijaConParentesisTest() throws ParseException {
		String[] tokens = { "(", "2", "+", "3", ")", "*", "4" };
		double respuestaEsperada = 20.0;
		double respuestaObtenida = Infija.evalúaInfija(tokens);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

	@Test
	public void evaluaInfijaConMultiplesParentesisTest() throws ParseException {
		String[] tokens = { "(", "2", "+", "(", "3", "-", "1", ")", ")", "/", "4" };
		double respuestaEsperada = 1.0;
		double respuestaObtenida = Infija.evalúaInfija(tokens);
		assertEquals(respuestaEsperada, respuestaObtenida, 0.0);
	}

}
