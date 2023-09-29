/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */

package ed.estructuras.nolineales;

/**
 * Representa nodos con datos ordenables.  Todos los nodos con datos a la
 * izquierda de este nodo anteceden al dato en este nodo, todos los datos en
 * nodos a su derecha son iguales o le suceden.
 * @author blackzafiro
 * @param <C> Tipo de dato contenido en el nodo.
 */
public interface NodoBinarioOrdenado<C extends Comparable<C>> extends NodoBinario<C> {
	
	/**
	 * Devuelve el nodo con el datos más grande a partir de este nodo, puede
	 * devolverse a sí mismo.
	 * @return nodo con el dato más grande.
	 */
	NodoBinarioOrdenado<C> másGrande();
	
	/**
	 * Devuelve el nodo con el datos más chico a partir de este nodo, puede
	 * devolverse a sí mismo.
	 * @return nodo con el dato más chico.
	 */
	NodoBinarioOrdenado<C> másChico();
}
