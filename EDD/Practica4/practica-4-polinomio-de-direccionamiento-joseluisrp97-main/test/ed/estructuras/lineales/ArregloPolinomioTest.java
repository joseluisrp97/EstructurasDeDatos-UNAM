/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.estructuras.lineales;

import org.junit.Test;
import static org.junit.Assert.*;
import ed.Calificador;

/**
 * Pruebas unitarias para la implementación con polinomio de direccionamiento de
 * la interfaz Arreglo.
 *
 * @author blackzafiro
 * @author mindahrelfen
 */
public class ArregloPolinomioTest extends Calificador {

	private static Arreglo a;
	private static Arreglo b;
	private static Arreglo c;

	@Override
	public void init() {
		a = new ArregloPolinomio(new int[]{4, 5});
		b = new ArregloPolinomio(new int[]{3, 5, 2});
		c = new ArregloPolinomio(new int[]{3, 4});
	}

	@Test(expected = IllegalSizeException.class)
	public void testConstructor() throws IllegalSizeException {
		startTest("4-dimensiones con una inválida", 1.0);
		try {
			Arreglo intento = new ArregloPolinomio(new int[]{5, 3, -1, 2});
		} catch (IllegalSizeException e) {
			addUp(1.0);
			passed();
			throw e;
		}
	}
	
	@Test
	public void obtenerÍndiceTest() {
		startTest("obtenerÍndice", 5.0);
		int expectedValue = 9;
		int actualValue = c.obtenerÍndice(new int[] {2, 1});
		assertEquals(expectedValue, actualValue);
		addUp(5.0);
		passed();
	}
	
	@Test(expected=IllegalSizeException.class)
	public void obtenerÍndiceExtraDimTest() {
		startTest("obtenerÍndice con índices de más", 1.0);
		int expectedValue = 9;
		try {
			int actualValue = c.obtenerÍndice(new int[] {2, 1, 3, 5});
		} catch(IllegalSizeException e) {
			addUp(1.0);
			passed();
			throw e;
		}
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void obtenerÍndiceInválidoTest() {
		startTest("obtenerÍndice con índices inválidos", 1.0);
		int expectedValue = 9;
		try {
			int actualValue = c.obtenerÍndice(new int[] {3, 1});
		} catch(IndexOutOfBoundsException e) {
			addUp(1.0);
			passed();
			throw e;
		}
	}

	@Test
	public void testBidimensional() {
		startTest("2-dimensiones", 4.0);
		int count = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				a.almacenarElemento(new int[]{i, j}, count);
				count++;
			}
		}
		int[] indices = {3, 2};
		int result = a.obtenerElemento(indices);
		assertEquals(result, 18);
		addUp(4.0);
		passed();
	}

	@Test
	public void testTridimensional() {
		startTest("3-dimensiones", 4.0);
		int count = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 2; k++) {
					b.almacenarElemento(new int[]{i, j, k}, count);
					count++;
				}
			}
		}
		int[] indices = {2, 3, 0};
		int result = b.obtenerElemento(indices);
		assertEquals(result, 27);
		addUp(4.0);
		passed();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testThrow1() {
		startTest("Obtener índice en almacenarElemento - excepción", 1.0);
		try {
			b.almacenarElemento(new int[]{0, 10, 2}, 100);
		} catch (IndexOutOfBoundsException e) {
			addUp(1.0);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testThrow2() {
		startTest("Obtener índice en obtenerElemento - excepción", 1.0);
		try {
			b.obtenerElemento(new int[]{0, 10, 2});
		} catch (IndexOutOfBoundsException e) {
			addUp(1.0);
			passed();
			throw e;
		}
	}
}