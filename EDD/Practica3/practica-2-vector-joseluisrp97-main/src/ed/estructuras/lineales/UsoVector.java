/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo resuelto a estudiantes actuales o potenciales.
 */
package ed.estructuras.lineales;

/**
 * Clase que muestra el uso del arreglo redimensionable <code>Vector</code>.
 *
 * @author veronica
 */
public class UsoVector {

	/**
	 * Muestra del uso del Vector.
	 */
	public static void main(String[] args) {
		System.out.println("Creando un vector de String...");
		Vector<String> v = new Vector<String>(new String[0]);

		// No hace nada, pues su capacidad inicial es 10.
		v.aseguraCapacidad(3);

		// Incrementa el tamaño del vector
		v.aseguraCapacidad(20);

		// Guarda la palabra "Hola" en la posición 2.
		v.asigna(2, "Hola");
		v.asigna(9, "Adiós");
		v.asigna(18, "Extra");

		System.out.println("El vector debe contener las palabras:\n"
			+ "\"Hola\"\n"
			+ "\"Adiós\"\n"
			+ "\"Extra\"\n");

		System.out.println("Imprimiendo a continuación...");
		for (int i = 0; i < v.leeCapacidad(); i++) {
			System.out.println("v[" + i + "] = " + v.lee(i));
		}
	}
}
