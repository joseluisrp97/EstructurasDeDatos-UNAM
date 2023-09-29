/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.visualización.demos;

import ed.estructuras.nolineales.ÁrbolRojinegro;
import ed.visualización.dibujantes.Dibujante;
import ed.visualización.dibujantes.DibujanteDeÁrbolBinario;


/**
 *
 * @author blackzafiro
 */
public class DemoÁrbolesRojinegros extends DemoÁrbolesBinariosOrdenados {
	
	@Override
	protected <C extends Comparable<C>> ÁrbolRojinegro<C> creaÁrbol() {
		return new ÁrbolRojinegro<>();
	}
	
    
    @MétodoDemo(nombre = "Dos elementos derecha", ejercicio = "[A, B]")
    public Dibujante dibujaÁrbol2b() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("A");
        árbol.add("B");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 1 (izquierda)", ejercicio = "[C, B, D, A]")
    public Dibujante dibujaÁrbolCBDA() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("C");
        árbol.add("B");
        árbol.add("D");
        árbol.add("A");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 1 (derecha)", ejercicio = "[B, A, C, D]")
    public Dibujante dibujaÁrbol4d() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("B");
        árbol.add("A");
        árbol.add("C");
        árbol.add("D");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 1b", ejercicio = "[D, C, A, B]")
    public Dibujante dibujaÁrbol4e() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("D");
        árbol.add("C");
        árbol.add("A");
        árbol.add("B");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 2", ejercicio = "[C, B, A]")
    public Dibujante dibujaLL() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("C");
        árbol.add("B");
        árbol.add("A");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 2 (espejo)", ejercicio = "[A, B, C]")
    public Dibujante dibujaRR() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("A");
        árbol.add("B");
        árbol.add("C");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 3", ejercicio = "[C, A, B]")
    public Dibujante dibujaLR() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("C");
        árbol.add("A");
        árbol.add("B");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Caso 3 (espejo)", ejercicio = "[B, A, C]")
    public Dibujante dibujaRL() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("B");
        árbol.add("A");
        árbol.add("C");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Cormen", ejercicio = "[11, 2, 14, 1, 7, 15, 5, 8]")
    public Dibujante dibujaCormen() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(11);
        árbol.add(2);
        árbol.add(14);
        árbol.add(1);
        árbol.add(7);
        árbol.add(15);
        árbol.add(5);
        árbol.add(8);
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Cormen 3 en 1", ejercicio = "[11, 2, 14, 1, 7, 15, 5, 8, 4]")
    public Dibujante dibujaCormen3en1() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(11);
        árbol.add(2);
        árbol.add(14);
        árbol.add(1);
        árbol.add(7);
        árbol.add(15);
        árbol.add(5);
        árbol.add(8);
        árbol.add(4);
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Muchos nodos", ejercicio = "[11, 2, 14, 1, 7, 15, 5, 8, 4, 54, 48, 10, 60, 58, 36, 3, 9, 40, 72, 6, 57, 77]")
    public Dibujante dibujaMuchosNodos() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(11);
        árbol.add(2);
        árbol.add(14);
        árbol.add(1);
        árbol.add(7);
        árbol.add(15);
        árbol.add(5);
        árbol.add(8);
        árbol.add(4);
        árbol.add(54);
        árbol.add(48);
        árbol.add(10);
        árbol.add(60);
        árbol.add(58);
        árbol.add(36);
        árbol.add(3);
        árbol.add(9);
        árbol.add(40);
        árbol.add(72);
        árbol.add(6);
        árbol.add(57);
        árbol.add(77);
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    /*@MétodoDemo(nombre = "Remover caso 1")
    public Dibujante dibujaRemueveCaso1() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        dibujante.setEstructura(árbol);
        árbol.add(new Integer(50));
        árbol.add(new Integer(25));
        árbol.add(new Integer(75));
        árbol.add(new Integer(15));
        //árbol.add(new Integer(60));
        árbol.add(new Integer(90));
        árbol.add(new Integer(7));
        árbol.add(new Integer(20));
        árbol.add(new Integer(55));
        árbol.add(new Integer(8));
        árbol.add(new Integer(3));
        árbol.add(new Integer(23));
        árbol.add(new Integer(17));
        árbol.add(new Integer(54));
        árbol.add(new Integer(53));
        árbol.add(new Integer(52));
        árbol.add(new Integer(51));
        árbol.add(new Integer(1));
        return new DibujanteDeÁrbolBinario(árbol);
    }*/
    
    @MétodoDemo(nombre = "Remover 1 antes", ejercicio = "[50]")
    public Dibujante dibujaRemueve1Antes() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(50);
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Remover 1", ejercicio = "[50]-[50]")
    public Dibujante dibujaRemueve1() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(50);
        árbol.remove(50);
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Remover A de caso 1 derecha", ejercicio = "[B, A, C, D]-[A]")
    public Dibujante dibujaRemueve2() {
        ÁrbolRojinegro<String> árbol = creaÁrbol();
        árbol.add("B");
        árbol.add("A");
        árbol.add("C");
        árbol.add("D");
        árbol.remove("A");
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Remueve 1 de Cormen (Caso 4)", ejercicio = "[11, 2, 14, 1, 7, 15, 5, 8]-[1]")
    public Dibujante dibujaRemueveCormen() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(11);
        árbol.add(2);
        árbol.add(14);
        árbol.add(1);
        árbol.add(7);
        árbol.add(15);
        árbol.add(5);
        árbol.add(8);
        árbol.remove(1);
        return new DibujanteDeÁrbolBinario(árbol);
    }
    
    @MétodoDemo(nombre = "Remueve 1,15,14 de Cormen (Caso 1)", ejercicio = "[11, 2, 14, 1, 7, 15, 5, 8]-[1, 15, 14]")
    public Dibujante dibujaRemueveCormen2() {
        ÁrbolRojinegro<Integer> árbol = creaÁrbol();
        árbol.add(11);
        árbol.add(2);
        árbol.add(14);
        árbol.add(1);
        árbol.add(7);
        árbol.add(15);
        árbol.add(5);
        árbol.add(8);
        árbol.remove(1);
        árbol.remove(15);
        árbol.remove(14);
        return new DibujanteDeÁrbolBinario(árbol);
    }
	
}
