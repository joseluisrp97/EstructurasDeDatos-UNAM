/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.visualización.gráficas;

import ed.estructuras.nolineales.Nodo;
import ed.estructuras.nolineales.NodoRojinegro;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

/**
 *
 * @author blackzafiro
 */
public class IGUNodoRojinegro extends IGUNodoÁrbol {
	
	private static final Stop[] altosRojo = { new Stop(0, Color.WHITE), new Stop(1, Color.RED)};
	private static final Stop[] altosNegro = { new Stop(0, Color.GRAY), new Stop(1, Color.BLACK)};
	
	private static final RadialGradient pinturaRoja =
			new RadialGradient(
					45,          // focusAngle,
                    0.5,         // focusDistance,
                    0,           // centerX,
                    0,           // centerY,
                    1.0,         // radius,
                    true,        // proportional,
                    CycleMethod.NO_CYCLE,
                    altosRojo
			);
	
	private static final RadialGradient pinturaNegra =
			new RadialGradient(
					45,          // focusAngle,
                    0.5,         // focusDistance,
                    0,           // centerX,
                    0,           // centerY,
                    1.0,         // radius,
                    true,        // proportional,
                    CycleMethod.NO_CYCLE,
                    altosNegro
			);
	
	public IGUNodoRojinegro(Nodo<?> nodo) {
		super(nodo);
		if (!(nodo instanceof NodoRojinegro)) {
			throw new ClassCastException("El nodo no es de tipo NodoRojinegro.");
		}
		NodoRojinegro nodorn = (NodoRojinegro<?>)nodo;
		switch(nodorn.getColor()) {
			case ROJO:
				círculo.setFill(pinturaRoja);
				break;
			case NEGRO:
				círculo.setFill(pinturaNegra);
				texto.setFill(Color.WHITE);
		}
	}
	
}
