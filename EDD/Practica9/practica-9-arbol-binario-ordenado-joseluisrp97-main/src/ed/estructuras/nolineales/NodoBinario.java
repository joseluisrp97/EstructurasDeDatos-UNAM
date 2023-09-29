/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.estructuras.nolineales;

import java.util.NoSuchElementException;

/**
 * Representa cualquier nodo con dos hijos.
 *
 * @author blackzafiro
 * @param <E> Tipo del dato a almacenar.
 */
public interface NodoBinario<E> {

	/**
	 * Devuelve el dato almacenado en este nodo.
	 *
	 * @return referencia al dato.
	 */
	E dato();

	/**
	 * Asigna el dato a este nodo.
	 *
	 * @param dato a asignar.
	 * @throws NullPointerException si <code>dato</code> es <code>null</code>.
	 */
	void dato(E dato) throws NullPointerException;

	/**
	 * Devuelve una referencia al padre de este nodo.
	 *
	 * @return referencia al nodo padre, <code>null</code> si no tiene.
	 */
	NodoBinario<E> padre();

	/**
	 * Asigna el nodo padre.
	 *
	 * @param padre Nodo padre, debe ser de la misma clase que esta instancia.
	 * @throws ClassCastException si <code>padre</code> no es instancia de la
	 * clase desde la que ejecuta el método.
	 */
	void padre(NodoBinario<E> padre) throws ClassCastException;

	/**
	 * Devuelve una referencia al padre de este nodo.
	 *
	 * @return referencia al hijo izquierdo, <code>null</code> si no tiene.
	 */
	NodoBinario<E> hijoI();

	/**
	 * Asigna el hijo izquierdo.
	 *
	 * @param hijoI Nodo hijo izquierdo, debe ser de la misma clase que esta
	 * instancia.
	 * @throws ClassCastException si <code>hijoI</code> no es instancia de la
	 * clase desde la que ejecuta el método.
	 */
	void hijoI(NodoBinario<E> hijoI) throws ClassCastException;

	/**
	 * Devuelve una referencia al padre de este nodo.
	 *
	 * @return referencia al hijo derecho, <code>null</code> si no tiene.
	 */
	NodoBinario<E> hijoD();

	/**
	 * Asigna el hijo derecho.
	 *
	 * @param hijoD Nodo hijo derecho, debe ser de la misma clase que esta
	 * instancia.
	 * @throws ClassCastException si <code>hijoD</code> no es instancia de la
	 * clase desde la que ejecuta el método.
	 */
	void hijoD(NodoBinario<E> hijoD) throws ClassCastException;

	/**
	 * Indica si este nodo no tiene hijos o todos sus hijos son árboles vacíos.
	 *
	 * @return ¿el nodo es hoja?
	 */
	boolean esHoja();

	/**
	 * Devuelve el altura del subárbol que tiene este nodo por raíz.
	 *
	 * @return altura del subárbol.
	 */
	int altura();

	/**
	 * Actualiza el valor de la altura de este nodo, asumiendo que el altura que
	 * reportan sus hijos es correcta.
	 *
	 * @return el valor actualizado.
	 */
	public int actualizaAltura();

	/**
	 * Remueve su referencia al hijo indicado, asignándole el valor
	 * <code>null</code>.
	 *
	 * @param hijo
	 * @throws NoSuchElementException si <code>hijo</code> no es hijo de este
	 * nodo.
	 */
	void remueveHijo(NodoBinario<E> hijo);

}
