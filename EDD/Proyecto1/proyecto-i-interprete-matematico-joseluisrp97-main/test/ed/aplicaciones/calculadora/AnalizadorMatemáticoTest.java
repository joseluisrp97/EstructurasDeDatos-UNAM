/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package ed.aplicaciones.calculadora;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blackzafiro
 */
public class AnalizadorMatemáticoTest {
	
	private AnalizadorMatemático analizador = new AnalizadorMatemático();
	
	@Test
	public void prefijaSencilla() {
		String cadena = "+ 5 -1";
		String[] respuestaEsperada = {"+", "5", "-1"};
		String[] respuestaObtenida = analizador.extraeTokens(cadena);
		System.out.println(cadena + " -> " + Arrays.toString(respuestaObtenida));
		assertArrayEquals(null, respuestaEsperada, respuestaObtenida);
	}
	
	@Test
	public void prefijaSencilla2() {
		String cadena = "+ 43 -9.8";
		String[] respuestaEsperada = {"+", "43", "-9.8"};
		String[] respuestaObtenida = analizador.extraeTokens(cadena);
		System.out.println(cadena + " -> " + Arrays.toString(respuestaObtenida));
		assertArrayEquals(null, respuestaEsperada, respuestaObtenida);
	}
	
	@Test
	public void infijaParéntesisConEspacios() {
		String cadena = "( 5 + -1 )";
		String[] respuestaEsperada = {"(", "5", "+", "-1", ")"};
		String[] respuestaObtenida = analizador.extraeTokens(cadena);
		System.out.println(cadena + " -> " + Arrays.toString(respuestaObtenida));
		assertArrayEquals(null, respuestaEsperada, respuestaObtenida);
	}
	
	@Test
	public void infijaParéntesis() {
		String cadena = "(5 + -1)";
		String[] respuestaEsperada = {"(", "5", "+", "-1", ")"};
		String[] respuestaObtenida = analizador.extraeTokens(cadena);
		System.out.println(cadena + " -> " + Arrays.toString(respuestaObtenida));
		assertArrayEquals(null, respuestaEsperada, respuestaObtenida);
	}
	
}
