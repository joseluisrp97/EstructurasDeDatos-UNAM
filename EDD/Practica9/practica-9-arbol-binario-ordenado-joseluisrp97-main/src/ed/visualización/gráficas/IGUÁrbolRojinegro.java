/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.visualización.gráficas;

import ed.estructuras.nolineales.NodoBinario;
import ed.estructuras.nolineales.ÁrbolBinario;

/**
 *
 * @author blackzafiro
 */
public class IGUÁrbolRojinegro extends IGUÁrbol {
	
	/**
	 * Auxiliar para crear el tipo de nodo que visualizará el contenido del
	 * nodo del árbol.
	 * @param nodo
	 * @return IGUNodoRojinegro o una subclase suya.
	 */
	protected IGUNodoRojinegro creaIGUNodo(NodoBinario<?> nodo) {
		return new IGUNodoRojinegro(nodo);
	}
	
	public IGUÁrbolRojinegro(ÁrbolBinario<?> árbol) {
		super(árbol);
	}
	
}
