/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.ordenamientos;

import org.junit.Test;

/**
 * Crea objetos que usan bubble sort.
 *
 * @author blackzafiro
 */
public class BubbleSorterTest extends OrdenadorSupertest {

	@Override
	public void init() {
		currentSorter = "Bubble";
	}

	@Override
	protected <C extends Comparable<C>> IOrdenador<C> creaOrdenador() {
		return new BubbleSorter<>();
	}

	@Test
	public void pruebaMejor() {
		startTest("Comprueba mejor caso.", 1.0, "Best");
		int[] mejor = creaOrdenador().mejorCaso(10);
		comprobarSiEstaOrdenado(mejor);
		addUp(1.0);
	}

	@Test
	public void pruebaPeor() {
		startTest("Comprueba peor caso.", 1.0, "Worst");
		int[] peor = creaOrdenador().peorCaso(10);
		comprobarOrdenInverso(peor);
		addUp(1.0);
	}
}
