/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo a estudiantes actuales o potenciales.
 */
package ed.visualización.gráficas;

import ed.estructuras.nolineales.NodoBinario;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Representación visual del nodo binario que se le indica en el constructor.
 *
 * @author blackzafiro
 */
public class IGUNodoÁrbol extends Pane {

	/**
	 * Radio del nodo.
	 */
	public static final double RADIO = 20;

	private static final Stop[] altos = {new Stop(0, Color.WHITE), new Stop(1, Color.CADETBLUE)};
	private static final Stop[] altosSeleccionado = {new Stop(0, Color.WHITE), new Stop(1, Color.BLUEVIOLET)};
	private static final RadialGradient pintura
		= new RadialGradient(
			45, // focusAngle,
			0.5, // focusDistance,
			0, // centerX,
			0, // centerY,
			1.0, // radius,
			true, // proportional,
			CycleMethod.NO_CYCLE,
			altos
		);
	private static final RadialGradient pinturaSeleccionado
		= new RadialGradient(
			45, // focusAngle,
			0.5, // focusDistance,
			0, // centerX,
			0, // centerY,
			1.0, // radius,
			true, // proportional,
			CycleMethod.NO_CYCLE,
			altosSeleccionado
		);
	private static final Color lineColor = Color.FIREBRICK.deriveColor(0, 1, 1, .6);

	/**
	 * Identificador único para este nodo.
	 */
	private NodoBinario<?> nodo;

	/**
	 * Figura con la que se dibuja el nodo.
	 */
	protected final Circle círculo;

	/**
	 * Campo para dibujar el contenido del nodo.
	 */
	protected final Text texto;
	
	/**
	 * Campo para dibujar el contenido del nodo padre.
	 */
	protected final Text textoPadre;
	
	/**
	 * Campo para dibujar el contenido del nodo hijo izquierdo.
	 */
	protected final Text textoHijoI;
	
	/**
	 * Campo para dibujar el contenido del nodo hijo derecho.
	 */
	protected final Text textoHijoD;

	/**
	 * Altura del nodo.
	 */
	private int h;

	/**
	 * Constructor.
	 *
	 * @param dato Nodo con datos.
	 */
	public IGUNodoÁrbol(NodoBinario<?> dato) {
		círculo = new Circle(RADIO, pintura);

		texto = new Text(dato.dato().toString()
			+ "\nh=" + dato.altura());
		texto.setTextOrigin(VPos.CENTER);
		texto.setTextAlignment(TextAlignment.CENTER);
		texto.setTranslateX(-RADIO / 2);
		
		textoPadre = new Text(dato.padre() != null ?
			dato.padre().dato().toString() : "null");
		textoPadre.setFill(Color.LIGHTBLUE);
		textoPadre.setTextAlignment(TextAlignment.CENTER);
		textoPadre.setTranslateY(-RADIO);
		
		textoHijoI = new Text(dato.hijoI() != null ?
			dato.hijoI().dato().toString() : "null");
		textoHijoI.setFill(Color.LIGHTBLUE);
		textoHijoI.setTextAlignment(TextAlignment.CENTER);
		textoHijoI.setTranslateX(-2 * RADIO);
		
		textoHijoD = new Text(dato.hijoD() != null ?
			dato.hijoD().dato().toString() : "null");
		textoHijoD.setFill(Color.LIGHTBLUE);
		textoHijoD.setTextAlignment(TextAlignment.CENTER);
		textoHijoD.setTranslateX(RADIO);

		this.getChildren().addAll(new Group(círculo),
			texto,
			textoPadre,
			textoHijoI,
			textoHijoD);
	}

	/**
	 * Altura del nodo.
	 *
	 * @return altura.
	 */
	int h() {
		return h;
	}

	/**
	 * Asigna el altura del nodo.
	 *
	 * @param h altura nueva.
	 */
	void h(int h) {
		this.h = h;
	}
}
