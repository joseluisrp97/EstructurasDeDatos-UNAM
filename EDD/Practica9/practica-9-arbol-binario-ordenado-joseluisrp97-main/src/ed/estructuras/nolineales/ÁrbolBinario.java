/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.nolineales;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author blackzafiro
 * @param <E> Tipo de los datos a almacenar en el árbol.
 */
public interface ÁrbolBinario<E> extends Collection<E> {

	/**
	 * Devuelve una referencia al nodo raíz.
	 *
	 * @return nodo raíz.
	 */
	NodoBinario<E> raíz();

	/**
	 * Devuelve un iterador que devuelve los datos del árbol en inorden. Este
	 * iterador no debe remover elementos.
	 *
	 * @return un iterador inorden.
	 */
	Iterator<E> iteradorInorden();
	
}
