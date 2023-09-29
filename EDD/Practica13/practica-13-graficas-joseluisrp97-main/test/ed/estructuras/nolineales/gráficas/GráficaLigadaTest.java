/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.nolineales.gráficas;

import ed.Calificador;
import ed.estructuras.nolineales.gráficas.GráficaLigada.IteradorAmplitud;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Pruebas unitarias para una gráfica con nodos.
 *
 * @author blackzafiro
 */
public class GráficaLigadaTest extends Calificador {

	public static GráficaLigada<Character> creaGráfica() {
		GráficaLigada<Character> g = new GráficaLigada<>();
		g.agregaVértice('A');
		g.agregaVértice('B');
		g.agregaVértice('C');
		g.agregaVértice('D');
		g.agregaVértice('E');
		g.agregaVértice('F');
		g.agregaArista('A', 'B', 3);
		g.agregaArista('A', 'C', 5);
		g.agregaArista('A', 'D', 9);
		g.agregaArista('B', 'C', 3);
		g.agregaArista('B', 'D', 4);
		g.agregaArista('B', 'E', 7);
		g.agregaArista('C', 'A', 3);
		g.agregaArista('C', 'D', 1);
		g.agregaArista('C', 'E', 6);
		g.agregaArista('C', 'F', 8);
		g.agregaArista('D', 'F', 2);
		g.agregaArista('E', 'D', 2);
		g.agregaArista('E', 'F', 5);
		g.agregaArista('F', 'D', 4);
		return g;
	}

	@Override
	protected void setCategories() {
		defineCategories(new String[]{
			"Inserción",
			"Borrado",
			"Recorrido",
			"Dijkstra"
		}, new double[]{
			0.2,
			0.2,
			0.2,
			0.4});
	}

	@Test
	public void Amplitud() {
		startTest("Amplitud", 3.0, "Recorrido");
		GráficaLigada<Character> g = creaGráfica();
		// Crear iterador
		Iterator<Character> it = g.iteradorAmplitud('A');
		Character[] resultadoEsperado = {'A', 'B', 'C', 'D', 'E', 'F'};
		for (Character c : resultadoEsperado) {
			//System.out.println(" Visitando " + c + " se obtuvo " + it.next());
			assertEquals(c, it.next());
		}
		addUp(3.0);
		passed();
	}

	@Test
	public void GráficaLigadaDijkstra() {
		startTest("Dijkstra", 3.0, "Dijkstra");
		GráficaLigada<Character> g = creaGráfica();
		List<Character> ruta = g.rutaDijkstra('A', 'F');
		char[] solución = {'A', 'C', 'D', 'F'};
		int i = 0;
		System.out.println("Ruta = " + ruta);
		for (Character c : ruta) {
			System.out.println("En ruta " + i + ": " + c);
			assertTrue(c == solución[i]);
			i++;
		}
		addUp(3.0);
		passed();
	}

}
