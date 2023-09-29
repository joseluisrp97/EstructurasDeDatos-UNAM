/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed.estructuras.lineales;

/**
 * Clase que inicia el uso de pruebas unitarias para la clase Cola Arreglo.
 *
 * @author mindahrelfen
 */
public class ColaArregloTest extends ColaTestA {

	@Override
	protected Cola<String> getCola() {
		return new ColaArreglo<>(new String[0]);
	}
}
