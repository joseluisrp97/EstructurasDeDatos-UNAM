/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.nolineales;

import ed.Calificador;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author blackzafiro
 */
public abstract class NodoBinarioTestA extends Calificador {
	
	@Override
	protected void setCategories() {
		defineCategories(new String[]{
			"Inserción",
			"Borrado",
			"Búsqueda",
			"*All",
			"Otros"
		}, new double[]{
			0.2,
			0.2,
			0.3,
			0.15,
			0.15,});
	}
	
	/**
	 * Devuelve un NodoBinario con un dato y sin vecinos.
	 * @param dato dentro del nodo.
	 * @return nodo.
	 */
	protected abstract NodoBinario<String> getNodoBinario(String dato);
	
	/**
	 * Test of dato method, of class NodoBOLigado.
	 */
	@Test
	public void testDato_0args() {
		startTest("Revisa el método de lectura para el dato", 1.0, "Otros");
		System.out.println("dato");
		NodoBinario<String> instance = getNodoBinario("Hola");
		Object expResult = "Hola";
		Object result = instance.dato();
		assertEquals(expResult, result);
		addUp(1.0);
		passed();
	}

	/**
	 * Test of dato method, of class NodoBOLigado.
	 */
	@Test
	public void testDato_GenericType() {
		startTest("Revisa el método de escritura para el dato", 1.0, "Otros");
		String dato = "Adiós";
		NodoBOLigado<String> instance = new NodoBOLigado("Hola");
		instance.dato(dato);
		assertEquals(dato, instance.dato());
		addUp(1.0);
		passed();
	}
	
	/**
	 * Test of dato method with null, of class NodoBOLigado.
	 */
	@Test(expected = NullPointerException.class)
	public void testDato_SetNull() {
		startTest("Revisa el método de escritura para el dato, no debe aceptar null", 1.0, "Otros");
		String dato = null;
		NodoBOLigado<String> instance = new NodoBOLigado("Hola");
		try {
			instance.dato(dato);
		} catch (NullPointerException e) {
			addUp(1.0);
			passed();
			throw e;
		}
	}

	/**
	 * Test of padre method, of class NodoBOLigado.
	 */
	/*
	public void testPadre() {
		System.out.println("padre");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		NodoBinario expResult = null;
		NodoBinario result = instance.padre();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/

	/**
	 * Test of hijoI method, of class NodoBOLigado.
	 */
	/*
	public void testHijoI() {
		System.out.println("hijoI");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		NodoBinario expResult = null;
		NodoBinario result = instance.hijoI();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/

	/**
	 * Test of hijoD method, of class NodoBOLigado.
	 */
	/*
	public void testHijoD() {
		System.out.println("hijoD");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		NodoBinario expResult = null;
		NodoBinario result = instance.hijoD();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/

	/**
	 * Test of esHoja method, of class NodoBOLigado.
	 */
	/*
	public void testEsHoja() {
		System.out.println("esHoja");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		boolean expResult = false;
		boolean result = instance.esHoja();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/

	/**
	 * Test of altura method, of class NodoBOLigado.
	 */
	/*
	public void testAltura() {
		System.out.println("altura");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		int expResult = 0;
		int result = instance.altura();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/
	
	/**
	 * Test of remueveHijo method, of class NodoBOLigado.
	 */
	/*
	public void testActualizaAltura() {
		System.out.println("remueveHijo");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		instance.remueveHijo(null);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/

	/**
	 * Test of remueveHijo method, of class NodoBOLigado.
	 */
	/*
	public void testRemueveHijo() {
		System.out.println("remueveHijo");
		NodoBOLigado instance = new NodoBOLigado("Hola");
		instance.remueveHijo(null);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	*/
	
}
