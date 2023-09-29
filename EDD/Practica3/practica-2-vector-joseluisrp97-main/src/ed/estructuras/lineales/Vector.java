/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo resuelto a estudiantes actuales o potenciales.
 */
package ed.estructuras.lineales;

import java.lang.Math;
import java.util.Arrays;

/**
 * Arreglo redimensionable.
 *
 * @author veronica
 * @author mindahrelfen
 */
public class Vector<T> {

	/**
	 * Define la capacidad inicial del <code>Vector</code>.
	 */
	public static final int INC = 10;

	/*
	 * Arreglo de tamaño cero a partir del cual será posible crear otros
	 * arreglos del mismo tipo.
	 */
	private T[] muestra;

	/*
	 * Arreglo donde se almacenan los datos del vector.
	 */
	private T[] buffer;

	/**
	 * Constructor que crea un <code>Vector</code> con capacidad inicial INC.
	 *
	 * @param muestra Un arreglo de tamaño cero de tipo <code>T</code>.
	 */
	public Vector(T[] muestra) {
		if (muestra.length != 0) {
			throw new IllegalSizeException("<muestra> debe ser un arreglo de tamaño cero.");
		}
		this.muestra = muestra;
		// Creación de un arreglo de tipo T.
		buffer = java.util.Arrays.copyOf(muestra, INC);
	}

	/// MÉTODOS DE ACCESO

	/**
	 * Devuelve el elemento almacenado en la posición <code>i</code>.
	 *
	 * @param i el índice del objeto a recuperar.
	 * @return el elemento almacenado en la posición <code>i</code>.
	 * @throws IndexOutOfBoundsException si
	 *                                   <code>!(0 &lt;= i &lt; this.leeCapacidad()) </code>.
	 */
	public T lee(int i) {
		if (i > this.leeCapacidad())
			throw new IndexOutOfBoundsException("Indice fuera de capacidad");
		T e = (T) (this.buffer[i]);
		return e;
	}

	/**
	 * Devuelve la capacidad actual de este <code>Vector</code>.
	 *
	 * @return la capacidad actual del <code>Vector</code>.
	 */
	public int leeCapacidad() {
		return this.buffer.length;
	}

	/// MÉTODOS DE MANIPULACIÓN

	/**
	 * Almacena el elemento <code>e</code> en la posición <code>i</code>.
	 *
	 * @param i el índice en el cual <code>e</code> será almacenado. Debe
	 *          cumplirse <code>0 &lt;= i &lt; this.leeCapacidad() </code>.
	 * @param e el elemento a almacenar.
	 * @throws IndexOutOfBoundsException si
	 *                                   <code>!(0 &lt;= i &lt; this.leeCapacidad())
	 * </code>                        .
	 */
	public void asigna(int i, T e) {
		if (i > this.leeCapacidad())
			throw new IndexOutOfBoundsException("Indice fuera de capacidad");
		this.buffer[i] = e;
	}

	/**
	 * Asigna la capacidad del <code>Vector</code>. Si
	 * <code>n &lt; this.leeCapacidad()</code> los elementos de <code>n</code>
	 * en adelante son descartados. Si <code>n &gt; this.leeCapacidad()</code>
	 * se agregan <code>null</code> en los espacios agregados.
	 *
	 * @param n la nueva capacidad del <code>Vector</code>, debe ser mayor que
	 *          cero.
	 * @throws IllegalSizeException si <code>n &lt; 1</code>.
	 */
	public void asignaCapacidad(int n) {
		if (n < 1)
			throw new IllegalSizeException("Número menor a 1");
		if (n == this.leeCapacidad())
			return;
		else {
			T[] nuevo = Arrays.copyOf(this.muestra, n);
			if (nuevo.length < this.leeCapacidad()) {
				for (int i = 0; i < nuevo.length; i++) {
					nuevo[i] = this.buffer[i];
				}
			} else {
				for (int i = 0; i < this.leeCapacidad(); i++) {
					nuevo[i] = this.buffer[i];
				}
			}
			this.buffer = nuevo;
			return;
		}

	}

	/**
	 * Garantiza que el <code>Vector</code> cuente al menos con capacidad para
	 * almacenar <code>n</code> elementos. Si
	 * <code>n &gt; this.leeCapacidad()</code> el tamaño del <code>Vector</code>
	 * es multiplicado por alguna potencia de dos, de tal modo que el
	 * requerimiento sea satisfecho con cierta holgura.
	 *
	 * @param n capacidad mínima que debe tener el <code>Vector</code>, no puede
	 *          ser menor a cero.
	 */
	public void aseguraCapacidad(int n) {

		int x, div, i, fin;
		x = this.leeCapacidad();
		if (n < x)
			return;
		div = (int) Math.ceil(n / x);
		i = (int) Math.ceil(Math.log((div)) / (Math.log(2)));
		if (i == 0) {
			fin = 2 * x;
		} else {
			fin = (int) ((Math.pow(2, i)) * x);
		}
		this.asignaCapacidad(fin);
	}
}
