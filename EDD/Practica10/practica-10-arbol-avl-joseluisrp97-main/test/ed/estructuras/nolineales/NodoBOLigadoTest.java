/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.nolineales;

import static org.junit.Assert.assertEquals;

/**
 * Pruebas unitarias para el nodo de un árbol binario.
 *
 * @author blackzafiro
 */
public class NodoBOLigadoTest extends NodoBinarioTestA {

	@Override
	protected NodoBinario<String> getNodoBinario(String dato) {
		return new NodoBOLigado<>(dato);
	}

	// TODO: Test setter throw ClassCastException.
	/**
	 * Test of dato method, of class NodoBOLigado.
	 */
	public void testMásGrande() {
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
	public void testMásChico() {
		startTest("Revisa el método de lectura para el dato", 1.0, "Otros");
		System.out.println("dato");
		NodoBinario<String> instance = getNodoBinario("Hola");
		Object expResult = "Hola";
		Object result = instance.dato();
		assertEquals(expResult, result);
		addUp(1.0);
		passed();
	}

}
