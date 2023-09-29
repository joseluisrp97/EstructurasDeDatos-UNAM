/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.lineales;

import java.util.Collection;

/**
 * Estructura "Último en entrar, primero en salir".
 *
 * @author veronica
 * @param <E> Tipo de los datos almacenar.
 */
public interface Pila<E> extends Collection<E> {

	/**
	 * Muestra el elemento al tope de la pila. Devuelve <code>null</code> si
	 * está vacía.
	 *
	 * @return Una referencia al elemento siguiente.
	 */
	public E mira();




	
	/**
	 * Devuelve el elemento al tope de la pila y lo elimina. Devuelve
	 * <code>null</code> si está vacía.
	 *
	 * @return Una referencia al elemento siguiente.
	 */
	public E expulsa();

	/**
	 * Agrega un elemento al tope de la pila.
	 *
	 * @param e Referencia al elemento a agregar.
	 * @throws NullPointerException si <code>e</code> es <code>null</code>.
	 */
	public void empuja(E e);
}
