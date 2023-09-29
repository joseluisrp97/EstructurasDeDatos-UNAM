/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.nolineales;

/**
 * Árbol binario ordenado. Permite una administración más eficiente de datos
 * comparables mediante una relación de orden.
 *
 * @author blackzafiro
 * @param <C> Los datos contenidos por esta estructura deben ser comparables.
 */
public interface ÁrbolBinarioOrdenado<C extends Comparable<C>> extends ÁrbolBinario<C> {

	/**
	 * Indica si el objeto comparable <code>o</code> se encuentra en este árbol.
	 * La complejidad de este método es log(n) en promedio.
	 *
	 * @param o
	 * @return si el objeto se encuentra en el árbol.
	 * @throws NullPointerException si <code>o</code> es <code>null</code>.
	 */
	public boolean contains(C o) throws NullPointerException;

	/**
	 * Remueve el objeto comparable <code>o</code>. La complejidad de este
	 * método es log(n) en promedio.
	 *
	 * @param o el objeto a remover
	 * @return si el objeto estuvo presente y lo removió
	 * @throws NullPointerException si <code>o</code> es <code>null</code>.
	 */
	public boolean remove(C o) throws NullPointerException;
}
