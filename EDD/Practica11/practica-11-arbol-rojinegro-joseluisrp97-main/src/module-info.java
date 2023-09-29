/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos, pero no está permitido
 * entregarlo tal cual a los estudiantes.
 */

module árboles {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens ed.visualización to javafx.fxml;

	exports ed.estructuras;
	exports ed.estructuras.nolineales;
	exports ed.visualización;

}
