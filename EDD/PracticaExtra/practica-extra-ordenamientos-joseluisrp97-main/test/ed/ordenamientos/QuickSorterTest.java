/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.ordenamientos;

import junit.framework.AssertionFailedError;
import org.junit.Test;

/**
 * Crea objetos que usan quick sort.
 *
 * @author blackzafiro
 */
public class QuickSorterTest extends OrdenadorSupertest {

	@Override
	public void init() {
		currentSorter = "Quick";
	}

	@Override
	protected <C extends Comparable<C>> IOrdenador<C> creaOrdenador() {
		return new QuickSorter<>();
	}

	/*
	@Test
	public void pruebaMejor() {
		// Hay varias estrategias dependiendo de la implementación.
		// Es mejor revisar a mano
	}*/
	@Test
	public void pruebaPeor() {
		startTest("Comprueba peor caso.", 1.0, "Worst");
		int[] peor = creaOrdenador().peorCaso(10);
		try {
			comprobarSiEstaOrdenado(peor);
		} catch (AssertionFailedError ae) {
			comprobarOrdenInverso(peor);
		}
		addUp(1.0);
	}
}
