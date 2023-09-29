/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.estructuras.lineales;

import org.junit.Test;
import static org.junit.Assert.*;
import ed.Calificador;
import java.util.Random;

/**
 * Batería de pruebas unitarias para la clase <code>Vector</code>.
 *
 * @author veronica
 * @author mindahrelfen
 */
public class VectorTest extends Calificador {

	private Random intGenerator;

	@Override
	public void init() {
		intGenerator = new Random();
	}

	/**
	 * Test of lee method, of class Vector.
	 */
	@Test
	public void testLee() {
		int i;
		Object expResult, result;
		startTest("lee de vector vacío", 1.0);
		i = intGenerator.nextInt(Vector.INC);
		Vector<Number> instance = new Vector<Number>(new Number[0]);
		expResult = null;
		result = instance.lee(i);
		assertEquals(expResult, result);
		addUp(1.0);
		passed();
	}

	/**
	 * Test of leeCapacidad method, of class Vector.
	 */
	@Test
	public void testLeeCapacidad() {
		int expResult, result;
		startTest("leeCapacidad", 1.0);
		Vector<Number> instance = new Vector<Number>(new Number[0]);
		expResult = Vector.INC;
		result = instance.leeCapacidad();
		assertEquals(expResult, result);
		addUp(1.0);
		passed();
	}

	/**
	 * Test of asignaCapacidad y leeCapacidad method, of class Vector.
	 */
	@Test
	public void testAsignaLeeCapacidad1() {
		int expResult, result;
		startTest("leeCapacidad tras redimensionar", 1.0);
		Vector<Number> instance = new Vector<Number>(new Number[0]);
		expResult = intGenerator.nextInt(1000) * Vector.INC;
		instance.asignaCapacidad(expResult);
		result = instance.leeCapacidad();
		assertEquals(expResult, result);
		addUp(1.0);
		passed();
	}

	/**
	 * Test of asignaCapacidad y leeCapacidad method, of class Vector.
	 */
	@Test
	public void testAsignaLeeCapacidad2() {
		int tamOriginal, tamNuevo, result;
		startTest("contenido tras redimensionar a menor capacidad", 2.0);
		Vector<Number> instance = new Vector<Number>(new Number[0]);

		tamOriginal = intGenerator.nextInt(1000) + Vector.INC;
		instance.asignaCapacidad(tamOriginal);
		Number[] arreglo = new Number[tamOriginal];
		for (int i = 0; i < arreglo.length; i++) {
			instance.asigna(i, arreglo[i]);
		}

		tamNuevo = intGenerator.nextInt(tamOriginal);
		instance.asignaCapacidad(tamNuevo);
		result = instance.leeCapacidad();
		assertEquals(tamNuevo, result);
		addUp(0.5);

		for (int i = 0; i < tamNuevo; i++) {
			assertEquals(instance.lee(i), arreglo[i]);
		}
		addUp(1.5);
		passed();
	}

	/**
	 * Test of asignaCapacidad y leeCapacidad method, of class Vector.
	 */
	@Test(expected = IllegalSizeException.class)
	public void testAsignaCapacidad() {
		int index;
		startTest("Asigna capacidad - valor inválido", 0.3);
		Vector<Number> instance = new Vector<Number>(new Number[0]);
		index = 0;
		try {
			instance.asignaCapacidad(index);
		} catch (IllegalSizeException e) {
			addUp(0.3);
			passed();
			throw e;
		}
	}

	/**
	 * Test of asigna y lee method, of class Vector.
	 */
	@Test
	public void testAsignaLee() {
		int i;
		String e;
		Vector<String> instance;
		startTest("asigna y lee - dentro de INC", 1.0);
		i = intGenerator.nextInt(Vector.INC);
		e = "Palabra";
		instance = new Vector<String>(new String[0]);
		instance.asigna(i, e);
		assertEquals(instance.lee(i), e);
		addUp(1.0);
		passed();
	}

	/**
	 * Test of aseguraCapacidad y leeCapacidad method, of class Vector.
	 */
	@Test
	public void testAseguraLeeCapacidad() {
		int n;
		startTest("aseguraLeeCapacidad - sin cambios", 2.0);
		n = intGenerator.nextInt(Vector.INC);
		Vector<Object> instance = new Vector<Object>(new Object[0]);
		instance.aseguraCapacidad(n);
		assertEquals(Vector.INC, instance.leeCapacidad());
		addUp(2.0);
		passed();
	}

	/**
	 * Test of aseguraCapacidad y leeCapacidad method, of class Vector.
	 */
	@Test
	public void testAseguraLeeCapacidad1() {
		int n;
		startTest("aseguraLeeCapacidad - con incremento", 1.0);
		n = Vector.INC + 1 + intGenerator.nextInt(10000);
		Vector<Object> instance = new Vector<Object>(new Object[0]);
		instance.aseguraCapacidad(n);
		assertTrue(n <= instance.leeCapacidad());
		addUp(2.0);
		passed();
	}

	/**
	 * Test of aseguraCapacidad y leeCapacidad method, of class Vector.
	 */
	@Test
	public void testAseguraLeeCapacidad2() {
		int n;
		startTest("aseguraLeeCapacidad - con incremento, caso frontera", 2.0);
		n = Vector.INC + 1;
		Vector<Object> instance = new Vector<Object>(new Object[0]);
		instance.aseguraCapacidad(n);
		assertTrue(n < instance.leeCapacidad());
		addUp(2.0);
		passed();
	}
}
