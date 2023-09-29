/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.ordenamientos;

import org.junit.Test;

/**
 * Crea objetos que usan selection sort.
 *
 * @author blackzafiro
 */
public class SelectionSorterTest extends OrdenadorSupertest {

	@Override
	public void init() {
		currentSorter = "Selection";
	}

	@Override
	protected <C extends Comparable<C>> IOrdenador<C> creaOrdenador() {
		return new SelectionSorter<>();
	}

	@Test
	public void pruebaMejor() {
		startTest("Comprueba mejor caso.", 1.0, "Best");
		int[] mejor = creaOrdenador().mejorCaso(10);
		assert (mejor.length == 10);
		addUp(1.0);
	}

	@Test
	public void pruebaPeor() {
		startTest("Comprueba peor caso.", 1.0, "Worst");
		int[] peor = creaOrdenador().peorCaso(10);
		assert (peor.length == 10);
		addUp(1.0);
	}
}
