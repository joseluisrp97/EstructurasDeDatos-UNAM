/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.visualización.dibujantes;

import ed.estructuras.nolineales.ÁrbolBinario;
import ed.estructuras.nolineales.ÁrbolBinarioOrdenado;
import ed.estructuras.nolineales.ÁrbolRojinegro;
import ed.visualización.gráficas.IGUÁrbol;
import ed.visualización.gráficas.IGUÁrbolRojinegro;
import java.util.Collection;
import javafx.scene.Node;

/**
 *
 * @author blackzafiro
 */
public class DibujanteDeÁrbolBinario extends Dibujante {

	protected final IGUÁrbol iguÁrbol;

	/**
	 * Asigna el <code>ÁrbolBinarioOrdenado</code> a dibujar.
	 *
	 * @param c la colección.
	 */
	public DibujanteDeÁrbolBinario(Collection<?> c) {
		super(c);
		if (c instanceof ÁrbolRojinegro<?>) {
			iguÁrbol = new IGUÁrbolRojinegro((ÁrbolBinarioOrdenado<?>) c);
		} else if (c instanceof ÁrbolBinario<?>) {
			iguÁrbol = new IGUÁrbol((ÁrbolBinarioOrdenado<?>) c);
		} else {
			throw new ClassCastException("c no es un árbol binario");
		}
	}

	@Override
	public Node sincronizaGráfica() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Node gráfica() {
		return iguÁrbol;
	}

}
