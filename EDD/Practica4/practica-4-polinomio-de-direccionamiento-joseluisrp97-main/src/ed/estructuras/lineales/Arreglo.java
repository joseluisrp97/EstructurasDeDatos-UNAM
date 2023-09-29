/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo resuelto a estudiantes actuales o potenciales.
 */
package ed.estructuras.lineales;

/**
 * Arreglo de n-dimensiones
 *
 * @author blackzafiro
 */
public interface Arreglo {

	/**
	 * Devuelve el elemento que se encuentra en la posición <code>th</code> en
	 * el arreglo multidimensional.
	 *
	 * @param indices arreglo con los índices del elemento a recuperar.
	 * @return el elemento almacenado en la posición <code>i</code>.
	 */
	public int obtenerElemento(int[] índices);

	/**
	 * Asigna un elemento en la posición <code>th</code> del arreglo
	 * multidimensional.
	 *
	 * @param índices arreglo con los índices donde se almacenará el elemento.
	 * @param elem    elemento a almacenar.
	 */
	public void almacenarElemento(int[] índices, int elem);

	/**
	 * Devuelve la posición <code>i</code> del elemento en el arreglo de una
	 * dimensión.
	 *
	 * @param índices arreglo con los índices donde está el elemento en el
	 *                arreglo multidimensional. Se debe cumplir que cada índice es
	 *                positivo y
	 *                menor que el tamaño de la dimensión correspondiente.
	 *
	 * @return la posición del elemento en el arreglo de una dimensión.
	 * @throws IndexOutOfBoundsException si alguno de los índices del arreglo no
	 *                                   está dentro del rango.
	 */
	public int obtenerÍndice(int[] índices);

}
